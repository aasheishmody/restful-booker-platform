# restful-booker-platform-ui-tests

<b>Command to run the tests with default options</b>

```
mvn clean verify  (browser-Chrome, baseurl-http://localhost:8080, headlessFlag-false)
```

<b>Command to run the tests with custom options</b>

```
mvn clean verify -Dbrowser=<browser> -DbaseUrl=<baseUrl> -DheadlessFlag=<headlessFlag> -DimplicitWaitTimeout=<implicitWaitTimeout> -DpageLoadTimeout=<pageLoadTimeout> -DtargetDir=<targetDir>
```

Examples:

Run on chrome in headlessmode

```
mvn clean verify -Dbrowser=Chrome -DheadlessFlag=true
```

Run on firefox in normal mode

```
mvn clean verify -Dbrowser=Firefox -DheadlessFlag=false
```

Run on chrome and firefox together

```
mvn clean verify -Dcucumber.options="--plugin json:target/chrome/json-files/cucumber.json" -DtargetDir=target/chrome -Dbrowser=Chrome
mvn clean verify -Dcucumber.options="--plugin json:target/firefox/json-files/cucumber.json" -DtargetDir=target/firefox -Dbrowser=Firefox
```

Cucumber HTML reports (With embedded screenshots as Test Evidence after each step and other details)

```
target/cucumber-html-reports/overview-features.html (Needs to be opened in a browser)
```

Alternate Test Report (to check how long did each of the threads took to run their respective tests) - 

```
target/index.html (Needs to be opened in a browser)
```