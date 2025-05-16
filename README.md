# Inventory-Management-System

This project simulates a parcel shipping registry system used by multiple university campuses across Montreal. It supports both on-demand stamp-based shipping and prepaid subscription labels for inter-campus deliveries.

MISS allows departments and facilities from participating institutions to manage their shipment records, track prepaid labels, and handle various shipping operations through a console-based interface.

---

## 📦 Project Overview

The system is structured around three core components:

### 1. **Stamps**
Handles the count and value of parcel stamps used for on-demand shipping.

- Supports five categories: A ($2), B ($5), C ($10), D ($15), E ($20)
- Add stamps, calculate total value, and check for equality between stamp sets
- Designed with flexibility to support varying combinations and updates

2. Label
Represents a prepaid shipping label with:

- Parcel type (Standard, Fragile, Confidential, etc.)
- Unique 8-digit ID (starting with 98)
- Expiry date (day/month)

Built-in validation ensures the label's integrity and supports date updates and comparisons.

3. Registry
Each registry holds a collection of `Stamps` and an array of `Label` objects.

- Add or remove labels
- Update label expiry information
- Add to the stamp collection
- Compare registries by stamp value, configuration, or label count
- Generate human-readable summaries of the shipment data

---

## 🖥️ Features

- Display all registries and their contents
- View individual registry details
- Compare registries by:
  - Total stamp value
  - Stamp configuration
  - Full equality (stamp value + label count)
- Add or remove labels
- Update label expiry dates
- Dynamically add stamps to any registry
- Interactive console menu for ease of use

---

## 🛠 Technologies Used

- Java
- Object-oriented principles (encapsulation, constructors, equals/toString)
- Arrays and dynamic resizing
- Input validation
- Static utility methods to avoid redundancy

---

## 🚀 How to Run

1. Ensure all Java files are in the same directory:
   - `Stamps.java`
   - `Label.java`
   - `Registry.java`
   - `MissDemo.java`

2. Compile the files:
   ```bash
   javac *.java
