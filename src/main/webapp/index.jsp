<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Registration</title>
        <link rel="stylesheet" 
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
              crossorigin="anonymous">
    </head>
    <body>
        <h1 style="text-align: center">Employee Registration Form</h1>
        <div class="container mt-5">
            <section>
                <form action="Controller" method="post">
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="firstname" class="form-label">First Name</label>
                            <input type="text" class="form-control" id="firstname" 
                                   placeholder="Enter your first name" name="firstName" >
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="lastname" class="form-label">Last Name</label>
                            <input type="text" class="form-control" id="lastname" 
                                   placeholder="Enter your last name" name="lastName" >
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="email" class="form-label">Enter your email</label>
                            <input type="email" class="form-control" id="email" 
                                   placeholder="Enter your email" name="email" >
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="phone" class="form-label">Enter your Phone number</label>
                            <input type="text" class="form-control" id="phone" 
                                   placeholder="Enter your phone number" name="phoneNumber" >
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="date" class="form-label">Enter the hire date</label>
                            <input type="date" class="form-control" id="date" 
                                   placeholder="Enter the hire date" name = "hireDate"  >
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="salary" class="form-label">Monthly Salary</label>
                            <input type="number" class="form-control" id="salary" 
                                   placeholder="Enter yout salary" name = "monthlySalary" >
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="department" class="form-label">Department</label>
                            <select class="custom-select" id="department" name="department">
                                <option value="HR">HR</option>
                                <option value="IT">IT</option>
                                <option value="Finance">Finance</option>
                                <option value="Marketing">Marketing</option>
                            </select>
                        </div>

                    </div>

                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </section>
        </div>

    </body>
</html>