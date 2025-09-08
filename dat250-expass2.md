# Experiment 2: Rest API with Spring Boot

### Topics
- technical problems that you encountered during installation and how you resolved
- any pending issues with this assignment that you did not manage to solve

#### Technical Problems Encountered
- When making API requests in Bruno and giving each request a test, they all came back as passed, even though I had not
yet implemented controllers yet, I have not yet figured out a way to fix this such that the test driven approach would
be implemented correctly.
- I chose to write tests in Bruno, but to automate testing, I found no easy way to do this with already written tests,
so that had to be done manually.


#### Pending Issues
- I am having some issues with the VoteController which I have yet to resolve with the @PostMapping and @Putmapping.
- Currently I cant find a way to gather all the options available for a certain poll, only one vote option at a time,
and as such I have not been able to implement the Post & Put mappings in VoteController
- Have translated the tests from Bruno into a native approach using springs RestClient, but have encountered some errorrs
which I have yet to resolve.

All in all a good learning experience, and would like to continue working on this assignment to try to resolve all my 
issues.



