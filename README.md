
 Pages
 GoogleBasePage - basic page object containing general methods all pages
 GoogleHomePage - page object main page google, containing element and methods with which we can search
 GoogleSearchResultsFirstPage - first page object with search term,  containing element and methods with which we can search and format result page
 GoogleSearchResultsSecondPage - second page object with search term,  containing element and methods with which we can search and format result page

 Test
 GoogleBasePage - basic test object containing general method
 GoogleSearchTest - test for validating search result, checks 1 and 2 pages containing search term.

 .gitignore - document with file ignore Git
 pom.xml - information about project, dependencies to external libraries
 search-tests.xml - parametrized browsers

 Downloading:
 Download 'Community' version of Intellij IDEA here: https://www.jetbrains.com/idea/download/#section=windows
 Download JDK 10.0.2 here: http://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html Install JDK
 Download geckodriver last version https://github.com/mozilla/geckodriver/releases and put this file in C:/Windows/System32
 Make sure you have Firefox version 62 installed (latest) and Google Chrome last version
 Download and Install Maven https://dev-pages.info/how-to-install-maven-on-windows-10/

 run tests via command line:
 open terminal
 insert a line "mvn -f C:\local\path\to\pom.xml clean install"




