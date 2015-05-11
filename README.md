TECHNOLOGY USED:
1) Spring 3.1.1
2) Hibernate 4.2.11
3) MySQL
4) Maven 3

REQUIREMENTS TO RUN THE APPLICATION
1) Java 1.6
2) Maven 
3) Tomcat 6

DEPLOYMENT NOTES
1) Please create a database in MySQL called “test” and import the User.sql from src/main/resources from the project.
2) Update the property values with local database details and root folder path in the test.properties located at src/main/resources. 
3) Please build the application with maven by running “Maven Install” and deploy the war file to tomcat.
4) Start the tomcat server.

THE ENDPOINTS
1) Build an endpoint that authenticates a user based on a login/password passed in a JSON payload.

http://localhost:8080/test/users/validateUser.json

Sample user accounts with username/password 1) nag/nag 2) tom/tom 3) messi/messi 

Sameple Request: {"username":"nag","password":"nag"}

Expected Responses from first end point
  SUCCESSFUL RESPONSE WOULD BE: 
  {
userData: 
{
state: "CA"
firstName: "Nagarjuna"
lastName: "Bikkasani"
city: "Culver City"
}
}
USER NOT FOUND RESPONSE:
{
exceptions: 
{
message: "User Not Found!"
urlRequested: "http://localhost:8080/test/users/validateUser.json"
}
}

2) Listing users by city(ex: seattle,reno)

http://localhost:8080/test/users/seattle.json
{
usersList: 
{
userData: 
[
3]
0:  
{
state: "WA"
firstName: "Nujitha"
lastName: "Bikkasani"
city: "Seattle"
}
1:  
{
state: "WA"
firstName: "Marshawn"
lastName: "Lynch"
city: "Seattle"
}
2:  
{
state: "WA"
firstName: "Tom"
lastName: "Brady"
city: "Seattle"
}
}
}

Grouping users by city
http://localhost:8080/test/users/group/seattle.json

{
usersDataGroups: 
[
2]
0:  
{
count: 1
gender: "F"
}
1:  
{
count: 2
gender: "M"
}
}

Providing the users by pagination

http://localhost:8080/test/users/5/2.json  
where 5 is the pagesize and 2 is the pagenumber.

{
usersList: 
{
userData: 
[
3]
0:  
{
state: "NV"
firstName: "Neymar"
lastName: "Da Silva Santos"
city: "Reno"
}
1:  
{
state: "NV"
firstName: "Messi"
lastName: "Lionel"
city: "Reno"
}
2:  
{
state: "CA"
firstName: "Nagarjuna"
lastName: "Bikkasani"
city: "Culver City"
}
totalPages: 2
currentPage: 2
pageSize: 5
}
}


http://localhost:8080/test/users/5/x.json
{
exceptions: 
{
message: "Failed to convert value of type 'java.lang.String' to required type 'java.lang.Integer'; nested exception is java.lang.NumberFormatException: For input string: "x""
urlRequested: "http://localhost:8080/test/users/5/x.json"
}
}

3) Build an endpoint that checks and returns the status of all components that it depends on

http://localhost:8080/test/health.json

{
health: 
{
memory: 
{
maxMemory: 129957888
allocatedMemory: 85000192
freeMemory: 71559040
}
database: 
{
message: "Doing Great!"
status: "Active"
}
}
}

4) Build an endpoint that when called returns the list of files in a given directory

http://localhost:8080/test/list/v1/Music.json(Versioning) It returns the files even from the subdirectory.

http://localhost:8080/test/list/Music.json

{
files: 
{
fileDetails: 
[
5]
0:  
{
fileName: ".DS_Store"
path: "/Users/nag/Desktop/.DS_Store"
}
1:  
{
fileName: ".localized"
path: "/Users/nag/Desktop/.localized"
}
2:  
{
fileName: "nag_test.docx"
path: "/Users/nag/Desktop/nag_test.docx"
}
3:  
{
fileName: "NAGARJUNA BIKKASANI.docx"
path: "/Users/nag/Desktop/NAGARJUNA BIKKASANI.docx"
}
4:  
{
fileName: "Screen Shot 2015-05-10 at 1.36.42 AM.png"
path: "/Users/nag/Desktop/Screen Shot 2015-05-10 at 1.36.42 AM.png"
}
}
}


NOTE: All the requests can support xml extension. So we can update the end points with .xml to see the XML response.

Versioning: Currently only Directory Lisitng service supports the versioning. 

Pagination: If the Requested page is not available then the response would be first page.

Health Check: it seems Spring Actuator provides all the metrics. 

Technologies: 
1) Used the technologies as we don't want to reinvent the wheel as long as it supports our requirements.
2) Open source
3) Spring: for it's dependency injection and loose coupling.
4) Hibenate: Productivity, Easy Maintenance and Portability.

All the unit test cases are available under src/test/java.










