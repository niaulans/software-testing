# Java Mobile Path

## Setting a Foundation for Successful Test Automation

### What is your goal for test automation?

- Reduce the time it takes to execute regression tests
- Reduce technical debt by closing sprints with test automation in place for the new features
- Enable continuous testing as part of build process

### Who is participating in the test automation effort?

- Developers
- Testers
- Business Analysts

### Which tests are you automating?

- Regression tests
- Smoke tests
- Sanity tests
- New feature tests
- Performance tests
- Security tests

### Test Automation Strategy

- Test Automation Pyramid: UI, Service, Unit
  - Unit: Close to the production code, quick to write and execute, low maintenance
  - Service: Middle layer, tests the business logic, faster than UI tests, less flaky
  - UI: Top layer, tests the user interface, slower to write and execute, more flaky
