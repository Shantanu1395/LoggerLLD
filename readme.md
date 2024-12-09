You have to design and implement a logger library that applications can use to log messages.
**Requirements**
1. **Client/application** makes use of your logger library to log messages to a sink.
   • **Message**
   • Has **content** which is of type string.
   • Has a **level** associated with it.
   • Is directed to a destination (**sink**).
   • Has **namespace** associated with it to identify the part of the application that sent the message.
   • **Sink**
   • This is the destination for a message (e.g., text file, database, console, etc.).
   • Sink is tied to one or more message levels.
   • One or more message levels can have the same sink.
2. **Logger library**
   • Requires configuration during sink setup.
   • Accepts messages from client(s).
   • Routes messages to the appropriate sink based on the level.
   • Supports the following message levels in the order of priority:
   **FATAL, ERROR, WARN, INFO, DEBUG.**
   • Message levels above a given message level should be logged.
   • **Example:** If INFO is configured as a message level, FATAL, ERROR, WARN, and INFO should be logged.
   • Enriches message with additional information (like timestamp) while directing message to a sink.
   **Sending messages**
   • Sink need **not** be mentioned while sending a message to the logger library.
   • A message level is tied to a sink.
   • You specify message content, level, and namespace while sending a message.
   **Logger configuration**
   • Specifies all the details required to use the logger library.
   • Library can accept one or more configurations for an application.
   • One configuration per association of message level and sink.
   • You may consider logger configuration as a key-value pair.
   • **Example:**
   • Time format
   • Logging level
   • Sink type
   • Details required for sink (e.g., file location)
