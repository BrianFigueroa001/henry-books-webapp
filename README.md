# Running prokect on IntelliJ

This project has been set up to work with 
IntelliJ Ultimate.

To run it on IntelliJ:

Prerequisite:

- IntelliJ Ultimate Version
- Local MySQL database
- Tomcat

1. Clone the project.

2. Have local MySQL database running.
   This project assumes the following:

    - Port: default
    - Username: root
    - Password: set an environmental variable named DB_PASSWORD with your local database's password.

3. Create a "henrybooks" schema in your database, and then execute the scripts stored
   in the "scripts" directory. 
   
   This will create and populate the tables in the henrybooks schema
   that this web application will use.
   
4. Ensure that Tomcat is installed.

5. Run the project in IntelliJ ultimate.