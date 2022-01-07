$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/seleniumframework.feature");
formatter.feature({
  "line": 1,
  "name": "Access seleniumframework.com website",
  "description": "Use selenium java with cucumber-jvm and navigate to website",
  "id": "access-seleniumframework.com-website",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1003423418,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Print title, url",
  "description": "",
  "id": "access-seleniumframework.com-website;print-title,-url",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I open seleniumframework website",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I validate title and URL",
  "keyword": "Then "
});
formatter.match({
  "location": "BlankStepDefs.i_open_seleniumframework_website()"
});
formatter.result({
  "duration": 7313498897,
  "status": "passed"
});
formatter.match({
  "location": "BlankStepDefs.i_print_title_and_URL()"
});
formatter.result({
  "duration": 842139904,
  "status": "passed"
});
formatter.after({
  "duration": 42838,
  "status": "passed"
});
});