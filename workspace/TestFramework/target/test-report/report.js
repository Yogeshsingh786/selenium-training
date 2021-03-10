$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/automation/features/AdditionCalculator.feature");
formatter.feature({
  "name": "Addition Calculator",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "User enters valid numbers as inputs for addition",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@positive"
    }
  ]
});
formatter.step({
  "name": "User enters First Number as \"\u003cFirstNumber\u003e\" and Second Number as \"\u003cSecondNumber\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "User should get addition result as \"\u003cResult\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "FirstNumber",
        "SecondNumber",
        "Result"
      ]
    },
    {
      "cells": [
        "2",
        "5",
        "7"
      ]
    },
    {
      "cells": [
        "0",
        "0",
        "0"
      ]
    },
    {
      "cells": [
        "-1",
        "5",
        "4"
      ]
    },
    {
      "cells": [
        "2",
        "-5",
        "-3"
      ]
    },
    {
      "cells": [
        "-2",
        "-5",
        "-7"
      ]
    },
    {
      "cells": [
        "1.235",
        "-0.255",
        "0.98"
      ]
    },
    {
      "cells": [
        "-1.235",
        "-0.255",
        "-1.49"
      ]
    },
    {
      "cells": [
        "-1.55",
        "-0.45",
        "-2"
      ]
    },
    {
      "cells": [
        "999999999999999999",
        "999999999999999999999",
        "1.001e+21"
      ]
    },
    {
      "cells": [
        "999.00",
        "111.01",
        "1110.01"
      ]
    }
  ]
});
formatter.background({
  "name": "User accesses calculator on browser",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "User is on Propine Addition Calculator",
  "keyword": "Given "
});
formatter.match({
  "location": "AdditionCalculator.user_is_on_Propine_Addition_Calculator()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User enters valid numbers as inputs for addition",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@positive"
    }
  ]
});
formatter.step({
  "name": "User enters First Number as \"2\" and Second Number as \"5\"",
  "keyword": "When "
});
formatter.match({
  "location": "AdditionCalculator.user_enters_First_Number_as_and_Second_Number_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should get addition result as \"7\"",
  "keyword": "Then "
});
formatter.match({
  "location": "AdditionCalculator.user_should_get_addition_result_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "User accesses calculator on browser",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "User is on Propine Addition Calculator",
  "keyword": "Given "
});
formatter.match({
  "location": "AdditionCalculator.user_is_on_Propine_Addition_Calculator()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User enters valid numbers as inputs for addition",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@positive"
    }
  ]
});
formatter.step({
  "name": "User enters First Number as \"0\" and Second Number as \"0\"",
  "keyword": "When "
});
formatter.match({
  "location": "AdditionCalculator.user_enters_First_Number_as_and_Second_Number_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should get addition result as \"0\"",
  "keyword": "Then "
});
formatter.match({
  "location": "AdditionCalculator.user_should_get_addition_result_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "User accesses calculator on browser",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "User is on Propine Addition Calculator",
  "keyword": "Given "
});
formatter.match({
  "location": "AdditionCalculator.user_is_on_Propine_Addition_Calculator()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User enters valid numbers as inputs for addition",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@positive"
    }
  ]
});
formatter.step({
  "name": "User enters First Number as \"-1\" and Second Number as \"5\"",
  "keyword": "When "
});
formatter.match({
  "location": "AdditionCalculator.user_enters_First_Number_as_and_Second_Number_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should get addition result as \"4\"",
  "keyword": "Then "
});
formatter.match({
  "location": "AdditionCalculator.user_should_get_addition_result_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "User accesses calculator on browser",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "User is on Propine Addition Calculator",
  "keyword": "Given "
});
formatter.match({
  "location": "AdditionCalculator.user_is_on_Propine_Addition_Calculator()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User enters valid numbers as inputs for addition",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@positive"
    }
  ]
});
formatter.step({
  "name": "User enters First Number as \"2\" and Second Number as \"-5\"",
  "keyword": "When "
});
formatter.match({
  "location": "AdditionCalculator.user_enters_First_Number_as_and_Second_Number_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should get addition result as \"-3\"",
  "keyword": "Then "
});
formatter.match({
  "location": "AdditionCalculator.user_should_get_addition_result_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "User accesses calculator on browser",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "User is on Propine Addition Calculator",
  "keyword": "Given "
});
formatter.match({
  "location": "AdditionCalculator.user_is_on_Propine_Addition_Calculator()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User enters valid numbers as inputs for addition",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@positive"
    }
  ]
});
formatter.step({
  "name": "User enters First Number as \"-2\" and Second Number as \"-5\"",
  "keyword": "When "
});
formatter.match({
  "location": "AdditionCalculator.user_enters_First_Number_as_and_Second_Number_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should get addition result as \"-7\"",
  "keyword": "Then "
});
formatter.match({
  "location": "AdditionCalculator.user_should_get_addition_result_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "User accesses calculator on browser",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "User is on Propine Addition Calculator",
  "keyword": "Given "
});
formatter.match({
  "location": "AdditionCalculator.user_is_on_Propine_Addition_Calculator()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User enters valid numbers as inputs for addition",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@positive"
    }
  ]
});
formatter.step({
  "name": "User enters First Number as \"1.235\" and Second Number as \"-0.255\"",
  "keyword": "When "
});
formatter.match({
  "location": "AdditionCalculator.user_enters_First_Number_as_and_Second_Number_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should get addition result as \"0.98\"",
  "keyword": "Then "
});
formatter.match({
  "location": "AdditionCalculator.user_should_get_addition_result_as(String)"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: expected:\u003c0.98[00000000000001]\u003e but was:\u003c0.98[]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat automation.stepDefinitions.AdditionCalculator.user_should_get_addition_result_as(AdditionCalculator.java:34)\r\n\tat ✽.User should get addition result as \"0.98\"(file:src/test/java/automation/features/AdditionCalculator.feature:9)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png", null);
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "User accesses calculator on browser",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "User is on Propine Addition Calculator",
  "keyword": "Given "
});
formatter.match({
  "location": "AdditionCalculator.user_is_on_Propine_Addition_Calculator()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User enters valid numbers as inputs for addition",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@positive"
    }
  ]
});
formatter.step({
  "name": "User enters First Number as \"-1.235\" and Second Number as \"-0.255\"",
  "keyword": "When "
});
formatter.match({
  "location": "AdditionCalculator.user_enters_First_Number_as_and_Second_Number_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should get addition result as \"-1.49\"",
  "keyword": "Then "
});
formatter.match({
  "location": "AdditionCalculator.user_should_get_addition_result_as(String)"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: expected:\u003c-1.49[00000000000002]\u003e but was:\u003c-1.49[]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat automation.stepDefinitions.AdditionCalculator.user_should_get_addition_result_as(AdditionCalculator.java:34)\r\n\tat ✽.User should get addition result as \"-1.49\"(file:src/test/java/automation/features/AdditionCalculator.feature:9)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded1.png", null);
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "User accesses calculator on browser",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "User is on Propine Addition Calculator",
  "keyword": "Given "
});
formatter.match({
  "location": "AdditionCalculator.user_is_on_Propine_Addition_Calculator()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User enters valid numbers as inputs for addition",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@positive"
    }
  ]
});
formatter.step({
  "name": "User enters First Number as \"-1.55\" and Second Number as \"-0.45\"",
  "keyword": "When "
});
formatter.match({
  "location": "AdditionCalculator.user_enters_First_Number_as_and_Second_Number_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should get addition result as \"-2\"",
  "keyword": "Then "
});
formatter.match({
  "location": "AdditionCalculator.user_should_get_addition_result_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "User accesses calculator on browser",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "User is on Propine Addition Calculator",
  "keyword": "Given "
});
formatter.match({
  "location": "AdditionCalculator.user_is_on_Propine_Addition_Calculator()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User enters valid numbers as inputs for addition",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@positive"
    }
  ]
});
formatter.step({
  "name": "User enters First Number as \"999999999999999999\" and Second Number as \"999999999999999999999\"",
  "keyword": "When "
});
formatter.match({
  "location": "AdditionCalculator.user_enters_First_Number_as_and_Second_Number_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should get addition result as \"1.001e+21\"",
  "keyword": "Then "
});
formatter.match({
  "location": "AdditionCalculator.user_should_get_addition_result_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "User accesses calculator on browser",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "User is on Propine Addition Calculator",
  "keyword": "Given "
});
formatter.match({
  "location": "AdditionCalculator.user_is_on_Propine_Addition_Calculator()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User enters valid numbers as inputs for addition",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@positive"
    }
  ]
});
formatter.step({
  "name": "User enters First Number as \"999.00\" and Second Number as \"111.01\"",
  "keyword": "When "
});
formatter.match({
  "location": "AdditionCalculator.user_enters_First_Number_as_and_Second_Number_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should get addition result as \"1110.01\"",
  "keyword": "Then "
});
formatter.match({
  "location": "AdditionCalculator.user_should_get_addition_result_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});