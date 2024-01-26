# Data Warehouse & Business Intelligence project
Master's team project of 3 members designed to showcase the configuration, implementation, management and using of a **data warehouse** starting from an OLTP database. It consists of 3 modules: Analysis, Database implementation and Application development. The [documentation file](https://github.com/AnaOlteanu/DWBI/blob/main/documentation/DWBI_documentation.pdf) 
contains a summary of all the stages of the project, while the [development of the application](https://github.com/AnaOlteanu/DWBI/tree/main/hotel-administration-app) represents a Spring MVC project 
that serves as an interface for solving the requirements needed.  
The theme chosen for this project is the management of hotel reservations. Our application aims to help a travel agency to organize the data related to the hotel reservations made by clients, with the aim of simplifying the creation of the monthly or annual reports it needs. In order to gain more insight into travel agency bookings, we will build a **data warehouse** that will contain all booking data, organized and available for decision analysis and reporting.
## Technologies used
- Oracle SQL database
- Spring Framework
- Thymeleaf
## Modules summary
1. **Analysis report**
      - objective: _creating an analysis report to define the data warehouse and develop the application that will run based on it_
  - description of the chosen model, entity and conceptual diagrams for the OLTP database
  - star diagram for the DW based on the OLTP schema
  - identifying the constraints, indexes, dimension objects, partitioning tables, optimization of SQL queries
2. **Database implementation**
      - objective: _defining the databases (OLTP&DW) based on the analysis report_
  - create and populate the OLTP and DW databases 
  - implementing the constraints, indexes, dimension objects, partitions and other queries needed for creating reports about the existing data
3. **Application development**
      - objective: _creating an interface that shows all the requirements described previously_
  - add and manage data in the OLTP database
  - view the impact of adding data in the OLTP DB on the DW
  - visual representations of the reports about the data in the DW
## Collaborative contribution
- all the requirements for the Analysis report
## Personal contribution
  - creating and populate the databases (pocedures)
  - defining the partitions and analyze the execution plan for a query that uses the partitioned tables (partitioning by ordering according to the month)
  - defining and validating the dimension objects
  - defining 2 queries for data reports relevant for the theme
  - app development - back-end + front-end (pair programming with another member of the teams)








