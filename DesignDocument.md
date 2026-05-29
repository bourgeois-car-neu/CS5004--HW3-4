# Payroll Generator Design Document


This document is meant to provide a tool for you to demonstrate the design process. You need to work on this before you code, and after have a finished product. That way you can compare the changes, and changes in design are normal as you work through a project. It is contrary to popular belief, but we are not perfect our first attempt. We need to iterate on our designs to make them better. This document is a tool to help you do that.

If you are using mermaid markup to generate your class diagrams, you may edit this document in the sections below to insert your markup to generate each diagram. Otherwise, you may simply include the images for each diagram requested below in your zipped submission (be sure to name each diagram image clearly in this case!)

## (INITIAL DESIGN): Class Diagram

Include a UML class diagram of your initial design for this assignment. If you are using the mermaid markdown, you may include the code for it here. For a reminder on the mermaid syntax, you may go [here](https://mermaid.js.org/syntax/classDiagram.html)

```mermaid
---
title: Payroll Generator UML
---
classDiagram
    direction LR
    PayrollGenerator --> IPayStub : uses
    PayrollGenerator --> IEmployee : uses
    PayrollGenerator --> Builder : uses
    Builder --> IEmployee
    Builder --> ITimeCard
    
    
    class PayrollGenerator {
        - DEFAULT_EMPLOYEE_FILE: String = "resources/employees.csv"
        - DEFAULT_PAYROLL_FILE: String = "resources/pay_stubs.csv"
        - DEFAULT_TIME_CARD_FILE: String = "resources/time_cards.csv"
        - PayrollGenerator()
        + main(args: String[]): void
    }
    
    class IPayStub {
        <<interface>>
        - getPay() double
        - getTaxesPaid() double
        - toCSV() String
    }

    class HourlyEmployee {
        - name: String
        - id: String
        - payRate: double
        - ytdEarnings: double
        - ytdTaxesPaid: double
        - pretaxDeductions: double
        + HourlyEmployee(name: String, id: String, payRate: double, ytdEarnings: double, ytdTaxesPaid: double, pretaxDeductions: double)
        + calculateGrossPay(hoursWorked: double) double 
    }

    class SalaryEmployee {
        - name: String
        - id: String
        - payRate: double
        - ytdEarnings: double
        - ytdTaxesPaid: double
        - pretaxDeductions: double
        + SalaryEmployeename: String, id: String, payRate: double, ytdEarnings: double, ytdTaxesPaid: double, pretaxDeductions: double)
        + calculateGrossPay(hoursWorked: double) double 
    }
    
    class IEmployee {
        <<interface>>
        - getName() String
        - getID() String
        - getPayRate() double
        - getEmployeeType() String
        - getYTDEarnings() double
        - getYTDTaxesPaid() double
        - getPretaxDeductions() double
        - runPayroll(double: hoursWorked)
        - toCSV() String
    }

    class ITimeCard {
        <<interface>>
        - getEmployeeID() String
        - getHoursWorked() double
    }

    class Builder {
        - Builder()
        + buildEmployeeFromCSV(csv: String) IEmployee
        + buildTimeCardFromCSV(csv: String) ITimeCard
    }

    class FileUtil {
        + EMPLOYEE_HEADER: String = "employee_type,name,ID,payRate,
          pretaxDeductions,YTDEarnings,YTDTaxesPaid"
        + PAY_STUB_HEADER: String = "employee_name,net_pay,taxes,
          ytd_earnings,ytd_taxes_paid"
        -  FileUtil()
        + readFileToList(file: String)
        + writeFile(outFile: String, lines: List<String>)  void
        + writeFile(outFile: String, lines: List<String>, backup: boolean) void
    }
```

## (INITIAL DESIGN): Tests to Write - Brainstorm

Write a test (in english) that you can picture for the class diagram you have created. This is the brainstorming stage in the TDD process. 

> [!TIP]
> As a reminder, this is the TDD process we are following:
> 1. Figure out a number of tests by brainstorming (this step)
> 2. Write **one** test
> 3. Write **just enough** code to make that test pass
> 4. Refactor/update  as you go along
> 5. Repeat steps 2-4 until you have all the tests passing/fully built program

You should feel free to number your brainstorm. 

1. Test that `Employee` class properly returns `name` from `getName()`
2. Test that `Employee` class properly returns `id` from `getId()`
3. Test that `ITimeCard` class returns `employee id` from `getEmployeeID`
4. Test that `ITimeCard` class returns `hours worked` from `getHoursWorked()`
5. Test that `IPayStub` class returns `pay` from `getPay()`
6. Test that `IPayStub` class returns `taxes paid` from `getTaxesPaid()`



## (FINAL DESIGN): Class Diagram

Go through your completed code, and update your class diagram to reflect the final design. We want both the diagram for your initial and final design, so you may include another image or include the finalized mermaid markup below. It is normal that the two diagrams don't match! Rarely (though possible) is your initial design perfect. 

> [!WARNING]
> If you resubmit your assignment for manual grading, this is a section that often needs updating. You should double check with every resubmit to make sure it is up to date.





## (FINAL DESIGN): Reflection/Retrospective

> [!IMPORTANT]
> The value of reflective writing has been highly researched and documented within computer science, from learning new information to showing higher salaries in the workplace. For this next part, we encourage you to take time, and truly focus on your retrospective.

Take time to reflect on how your design has changed. Write in *prose* (i.e. do not bullet point your answers - it matters in how our brain processes the information). Make sure to include what were some major changes, and why you made them. What did you learn from this process? What would you do differently next time? What was the most challenging part of this process? For most students, it will be a paragraph or two. 
