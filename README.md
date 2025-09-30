# Group Sprint 1: Bookazon


```

███████╗██████╗ ██████╗ ██████╗ ██╗   ██╗ ██████████╗
██╔════╝██╔══██╗██╔══██╗  ██╗║  ████╗ ██║╚══ ██╔══╝
███████╗██████╔╝██████╔╝  ██╔╝  ██║██╔██╗    ██║
╚════██║██╔══██╗██╔═██═╝  ██═══╝██║ ████╚╗   ██
███████║██║  ██║██║ ██║ ██████║ ██    ██║    ██║      
╚══════╝╚═╝  ╚═╝╚═╝ ╚═╝ ╚═╝╚═╝ ╚═══╝ ╚═╝
                                ██
                               ███
                                ██
                                ██
                                ██
                                ██
                              ██████

```


An assignment for redesigning software and refactoring code smells. Part of Software Engineering class CS321, fall 2025.

---

## Project Objectives
- Practice redesigning a software project with guidance from **SOLID design principles**.
- Refactor code to address **design smells** and enhance **readability** and **maintainability**.
- Apply **Agile Scrum** and **project management** fundamentals.
- Collaborate as a team using **Git** and **GitHub** effectively.

---

## Overview
We took a small online bookstore and turned it into a cleaner, extensible system. The headline features this sprint:
- **Order printouts show discount details** (tier, % off, amount, final total).
- **Catalog supports more than books**: Audiobooks, DVDs, and E-books under a common `MediaItem`.
- Responsibilities were separated so **domain code doesn’t print** and **validation doesn’t leak**.

### Example Output from the Terminal (console)
=== Order Summary ===
Items: 3
Subtotal: $47.97
Discount (gold 15%): -$7.20
Total: $40.77

---
```
 /\_/\  
( o.o ) 
 > ^ <
```

## Repository Management
- Forked the starter repo and added all collaborators.
- Worked in **feature branches** for each issue (ex. `feat/discount-print`, `refactor/bookazon-view`).
- Every change merged via **PR + review**; main/development stayed green.

---

## Class Diagram and Code Review

![UML Overview](docs/uml-after.png)

<sub>[Open full-size diagram](docs/uml-after.png) • [Source file (draw.io)](docs/uml-after.drawio)</sub>

---

## SOLID Principles, Code Smells, and Technical Debt
## Design Problems & Code Smells (Postcards)

| Area | Smell / Problem | Where / Example | Our Fix / Suggested Fix | Principle |
|---|---|---|---|---|
| **Bookazon** | **Doing too much** (SRP) | Stores collections, manages add/remove, updates details, prints, owns `main`.<br>`viewBooks()`, `viewUsers()`, `updateBookDetails(...)`, `updateRole(...)`, `main(...)` | Return data from `view*()`; move printing to a printer class; delegate updates to the domain (`MediaItem.apply`, `User.updateSubscription`); keep `main` minimal. | SRP |
| **Bookazon** | **OCP violation** | `updateBookDetails(Book, String newTitle, String newAuthor, int newYearPublished, double newPrice, boolean isPaperback)` must change whenever attributes change. | Replace parameter list with a single **details object** (e.g., `MediaDetails` / `BookDetails`) or a builder; `Bookazon` calls `item.apply(details)`. | OCP |
| **Bookazon** | **Feature Envy** | `book.setTitle(...)`, `book.setAuthor(...)`, … `user.setSubscription(role)` done from `Bookazon`. | Push behavior into the objects: `item.apply(details)`, `user.updateSubscription(role)`. | Encapsulation / Tell-Don’t-Ask |
| **Bookazon** | **Data Clump** | Repeated parameter bundle for updates: `newTitle, newAuthor, newYearPublished, newPrice, isPaperback`. | Replace with `BookDetails` / `MediaDetails`. | SRP |
| **Book** | **Doing too much** (SRP) | Holds data, **validates** (`isPriceValid`, `isTitleValid`, …) and **prints** (`printBookDetails`). | Move validation to `BookValidator`; move rendering to a printer or `BookDetails -> toString`; keep `Book` as state + behavior only. | SRP |
| **Book** | **OCP violation (formatting)** | `printBookDetails()` prints fixed console format; changing format requires editing class. | Return a data view or accept a `Renderer`; printers (console/JSON/web) format externally. | OCP |
| **Book** | **Primitive Obsession** | `String title/author`, `int yearPublished`, `double price`, `boolean isPaperback`. | Use value objects: `Title`, `Author`, `YearPublished`, `Price`; replace boolean flag with **polymorphism** (`Paperback`, `Hardcover`) or `BookType`. | Encapsulation / Polymorphism |
| **Order** | **Doing too much** (SRP) | Stores metadata, manages addresses, items, **applies discounts**, **prints**. | Extract pricing to `PricingPolicy` + `Subscription`; move printing to `OrderPrinter`; keep `Order` as aggregate + totals. | SRP |
| **Order** | **OCP violation (discounts)** | `calculatePrice(String subscription)` with `if/else` on `"gold"`, `"silver"`, … | Replace with `Subscription.applyTo(subtotal)` or strategy map; inject `PricingPolicy`. | OCP |
| **Order** | **Primitive Obsession** | Addresses as six strings; subscription as `String`; dates as `String`. | Introduce `PostalAddress`, `Subscription` (value/strategy), and proper date/time types (`LocalDate`/`LocalDateTime`). | Encapsulation |
| **Order** | **Data Clump** | Shipping/Billing each have 6 params across methods. | Replace with `PostalAddress` object; use `setShippingAddress(PostalAddress)` / `setBillingAddress(PostalAddress)`. | SRP |
| **Order** | **Magic Numbers** | Discount rates inline. | Centralize in `Subscription` or `PricingPolicy` constants/strategies. | Clarity |
| **Order** | **DIP violation** | Depends on strings + embedded rules. | Depend on abstractions: `Subscription`, `PricingPolicy`, `OrderPrinter`. | DIP |
| **User** | **Doing too much** (SRP) | Identity, subscription, two addresses, cart ops, and checkout/order creation. | Keep identity + preferences; let `OrderService` handle checkout; keep address logic in `PostalAddress`. | SRP |
| **User** | **Primitive Obsession** | Address parts as strings; subscription as `String`. | Use `PostalAddress`; use `Subscription` object/factory. | Encapsulation |
| **User** | **Data Clumps** | `setShippingAddress(l1,l2,city,state,zip,country)` and similar for billing. | Collapse to `PostalAddress` parameter. | SRP |
| **Cross-cutting** | **Law of Demeter** | Callers doing `product.getValidator().isValid(product.getDetails())`. | Provide `MediaItem.isValid()` and `validationReport()` wrappers. | LoD |


---

## Propose Solutions and Create Issues
- Discuss potential solutions for each identified design problem and code smell.
- Add these problems as **issues** in your GitHub repository. Each issue should include:
  - A clear description of the problem (with references to the code).
  - The proposed solution (e.g., refactoring, code redesign, or applying SOLID principles).

---

## Adding New Features
- Extend the system's functionality by:
  - **Updating the order printing** to include discount details.
  - Expanding the system to support **new media types**: audiobooks, DVDs, and e-books.
- Plan the necessary design changes to incorporate these new features while maintaining SOLID principles.

---

## Milestone and Issue Organization
- One sprint milestone with labeled issues: enhancement, refactor, design, bug.
- Each PR had a short summary + screenshot or output snippet when relevant.

---

## Teamwork and GitHub Practices
- Each team member should select **one issue** at a time to work on and may take on another only after completing the current one.
- Follow Git/GitHub practices by:
  - Creating a **feature branch** for each issue.
  - Ensuring that your branch doesn't break the system (test your changes).
  - **Opening a pull request (PR)** to merge your changes back into the main branch.
- **Code Reviews:** Each team member must review at least **one PR** from another member to ensure code quality and consistency.
- Keep the **main branch** in a working state at all times. No broken or unfinished code should be merged into the main branch.
- Ensure no **stale feature branches** remain after a milestone. Clean up unused branches.

---

## Extensions
- Burndown shown in the report document
- This creative README, which includes different title formatting, tables, documentation, and fun markdown images.

---

## Report (Google Doc)
Organize a **Google Doc report** with the following sections, including screenshots and text to communicate the objectives of your work:

1. **Abstract:**  
   A brief summary of the Sprint in your own words (no more than 150 words). Give context and summarize the outcome.

2. **Results:**  
   A section outlining the results of your Sprint, including links to your **public repository**.

3. **Reflection:**  
   Reflect on what you learned during the Sprint.

4. **Extensions:**  
   Describe any extensions you undertook, supported by text output, graphs, tables, or images.

5. **References/Acknowledgements/AI Use Documentation:**  
   List any references used and acknowledge AI tools, if applicable, that contributed to your work.
