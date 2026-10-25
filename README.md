# CS 360: Mobile Architecture and Programming

## Inventory App — Project Three Portfolio Artifact

This repository contains my completed Inventory App project for CS 360. The Project Three ZIP includes the Android application code and the user interface developed during Project Two. The app launch plan may also be included as supporting documentation.

### App requirements, goals, and user needs

I developed the Inventory App to help users keep track of items and their quantities in one place. The main goal was to provide a straightforward way to create an account, sign in, view inventory, add items, change quantities, and remove items that are no longer needed. The app was also designed to support optional SMS alerts when an item reaches zero stock. These features address the need for an organized, accessible inventory record that users can update as their stock changes.

### Screens, features, and user-centered design

The app includes a login and account creation screen, an inventory management screen, and an SMS notification settings screen. I designed the inventory interface around common tasks so users can quickly see item names and quantities and find the controls for adding, editing, and deleting entries. I also considered users who do not want to grant SMS permission: the core inventory features should remain available without text notifications. Keeping the screens focused on specific tasks helped make the app easier to navigate. During testing, I was able to access the inventory screen and use the quantity-editing controls successfully.

### Development approach and reusable strategies

I approached development in stages, starting with the user interface from Project Two and then connecting it to the application logic and SQLite database. I separated database operations from the activity code so the responsibilities were easier to understand and maintain. I worked through the create, read, update, and delete (CRUD) operations and checked their behavior as I progressed. This incremental approach is useful for future projects because it makes defects easier to isolate and reduces the risk of introducing several untested changes at once.

### Testing and lessons learned

I tested the app in the Android Emulator by accessing the inventory screen, adding items, changing quantities, and deleting entries. I also closed and reopened the app to check whether inventory changes were retained; the updated data was still available after restarting. These checks helped verify the connection between the interface and persistent storage. Testing is essential because a screen can appear correct even when the underlying behavior or data handling is not working. SMS permission handling and actual message delivery require separate verification on a suitable emulator or device before a public release.

### Challenges and innovation

One challenge was moving from a visual design to an app that stores and updates real data. The inventory screen needed to reflect database changes rather than rely on static sample entries. I addressed this by loading inventory records from SQLite and refreshing the displayed items after operations such as editing or deleting. This helped connect the UI and data layers while preserving a simple workflow for the user.

### Component that best demonstrates my skills

The inventory management and SQLite persistence functionality best demonstrate what I learned. Implementing CRUD operations required me to coordinate user input, database queries, and UI updates. Confirming that edits remained available after restarting the app was especially important because it demonstrated that the app was doing more than temporarily displaying information. This project strengthened my understanding of Android application structure and gave me a mobile development artifact to include in my software engineering portfolio.

### Portfolio files

- `Ogaga_Inventory_App_Project_Three.zip` — Android Studio project source and completed UI design.
- App launch plan (optional supporting document).

### AI acknowledgment

I used OpenAI ChatGPT (2026) to assist with drafting and organizing this portfolio reflection and with aspects of the application implementation. I reviewed the work and tested the inventory functionality described above.
