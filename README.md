# CS 360 Project Three: Inventory App

Built from the Project Two user interface. Features: account registration and login; persistent SQLite inventory; add, view, edit quantity, delete; zero-stock SMS with runtime permission and configurable recipient.

## Testing in Android Studio
1. Register and log in. 2. Add an item, close and reopen the app, log in and verify persistence. 3. Edit quantity and delete. 4. Deny SMS permission and verify CRUD still works. 5. Grant SMS permission, save a test recipient and reduce stock to zero on an emulator with SMS support.

The application has not been compiled or emulator-tested in this environment. SMS delivery requires an emulator/device capable of sending SMS; permission does not guarantee delivery. SEND_SMS is a restricted permission for Google Play publication. For production use, replace the educational salted SHA-256 password digest with a dedicated password KDF and perform a security review.

AI acknowledgment: OpenAI ChatGPT (2026) assisted in writing the application and launch plan.
