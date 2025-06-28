```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="SanitySuite">
    <test name="SanityTests">
        <groups>
            <run>
                <include name="sanity"/>
            </run>
        </groups>
        <classes>
            <class name="tests.LoginTest"/>
        </classes>
    </test>
</suite>
```

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="RegressionSuite">
    <test name="RegressionTests">
        <groups>
            <run>
                <include name="regression"/>
            </run>
        </groups>
        <classes>
            <class name="tests.LoginTest"/>
        </classes>
    </test>
</suite>
```

```bash
# Run smoke test only
mvn clean test -DsuiteXmlFile=src/test/resources/testng-smoke.xml
mvn clean test "-Dsurefire.suiteXmlFiles=sanity.xml"

# Run sanity test only
mvn clean test -DsuiteXmlFile=src/test/resources/testng-regression.xml
```
