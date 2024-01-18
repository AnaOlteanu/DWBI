# Data Warehouse & Business Intelligence project
Master's team project of 3 members designed to showcase the configuration, implementation, management and using of a data warehouse starting from an OLTP database. It consists in 3 modules: Analysis, Database implementation and Application development. The [documentation file](https://github.com/AnaOlteanu/DWBI/blob/main/documentation/DWBI_documentation.pdf) 
contains a summary of all the stages of the project, while the [development of the application](https://github.com/AnaOlteanu/DWBI/tree/main/hotel-administration-app) represents a Spring MVC project 
that serves as an interface for solving the requirements needed.  
The theme chosen for this project is the management of hotel reservations.
## Technologies used
- Oracle SQL database
- Spring Framework
## Modules summary
1. **Analysis**
      - objective: _defining an analysis report to define the data warehouse and create the application that will run based on it_
  - description of the model chosen, entity and conceptual diagrams for the OLTP database
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
## Personal contribution
  - creating the OLTP and the DW scehmas
  - creating and populate the databases
  - identifying and implementing the partitioning tables and the resulting partitions
  - defining and optimization of a SQL query
  - defining 5 SQL queries that will serve as reports of the data in the DW
  - app development
  - writing the documentation for the Analysis and Database implementation








