
# OT250-server -  Java - Spring Boot (Project: API REST) 🚀

## Developer team 🖥️

**MENTOR:**
* **Francisco Mastucci** - [LinkedIn](https://www.linkedin.com/in/franmastucci/) - [GitHub](https://github.com/franmastucci)

**MEMBERS:**
* **Jose Luis Panero** - [LinkedIn](https://www.linkedin.com/in/josepanero/ ) - [GitHub](https://github.com/junx2000)
* **José Ignacio Ibarrondo Pelaez** - [LinkedIn](https://www.linkedin.com/in/joséignacioibarrondopelaez/) - [GitHub](https://github.com/ibarrondojosei)
* **Alejandro Moll** - [LinkedIn](https://www.linkedin.com/in/alejandro-moll/) - [GitHub](https://github.com/Alex-Moll)
* **Martin Gutierrez** - [LinkedIn](https://www.linkedin.com/in/martgutierrez/) - [GitHub](https://github.com/gutierrezMartinIvan)
* **Larry Aguilera** - [LinkedIn](https://www.linkedin.com/in/larry-aguilera-081340b1/) - [GitHub](https://github.com/larrydaguilera)

## THIS PROJECT IS PART OF [ALKEMY](https://www.alkemy.org/) ACELERATION

* Our most sincerely gratitude, for all the knowledge received and the opportunity to connect with our first job in IT.

### TARGET

ONG Project - "SOMOS MÁS". 
Developing an API being part of a developer's team. Code the backend server that manages the "SOMOS MAS" ONG website.

### Implemented Technologies
- 👉 Java and Spring Boot
- 👉 Spring Security Library
- 👉 REST Technology
- 👉 Amazon AWS Service.
- 👉 SendGrid Service.
- 👉 Pagination.
- 👉 Use of Data Transfer Object.
- 👉 Testing (JUnit and Mockito).
- 👉 Swagger Documentation.

---------------------------

### To execute the API 👇🏻
* Download the project or clone it.
* Open the console and go to the project folder.
* Excute the following commands: ``` mvn clean install ```  and then ``` mvn spring-boot:run ``` .
* Open the explorer and go to http://localhost:8080/swagger-ui/index.html#/ .
* There you will be able to see the API documentation and interact with the endpoints.


## Seeder
### Through the use of a SEEDER, the following users with the role ADMIN and USER are already pre-loaded.

**User list with ROLE_ADMIN:**

USERS SEED
<table>
<thead>
<tr>
<th>email</th>
<th>role</th>
</tr>
</thead>
<tbody>
<tr>
<td>emailadmin{X}@mail.com</td>
<td>admin</td>
</tr>
<tr>
<td>emailuser{X}@mail.com</td>
<td>user</td>
</tr> 
</tbody>
</table>


#### *By default, 10 users with admin role and 10 users with user role will be created where the {X} in the email is a number from 0 to 9 per admin user, with normal user the {X} is a number from 11 to 20. All users have "1234" as password.*


ROLES SEED
<table>
<thead>
<tr>
<th>ID</th>
<th>Description</th>
<th>Name</th>
</tr>
</thead>
<tbody>
<tr>
<td>1</td>
<td>ROLE_USER</td>
<td>USER</td>
</tr>
<tr>
<td>2</td>
<td>ROLE_ADMIN</td>
<td>ADMIN</td>
</tr> 
</tbody>
</table>
