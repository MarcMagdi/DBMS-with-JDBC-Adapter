# DBMS with JDBC Adapter
## Project Overview:
DBMS is a database management system build on java with a JDBC adapter to connect it to Java.

### Project Features:
#### As a user I have the ability to:
- login with a predefined username and password
- execute any SQL command
- change the default saving data option and choose between xml, json or protocol buffers

### Technical Perspective:
All data processing is through a command line so it depends heavily on string processing using regex.The DBMS stores its data in xml, json, or using protocol buffers. We used multiple design patterns to meet our need like Factory, Builder, Strategy, and Singleton.
