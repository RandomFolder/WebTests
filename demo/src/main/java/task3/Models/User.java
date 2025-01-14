package task3.Models;

public class User
{
    private String firstName;
    private String lastName;
    private String age;
    private String email;
    private String salary;
    private String department;


    public String getFirstName()
    {
        return this.firstName;
    }


    public String getLastName()
    {
        return this.lastName;
    }


    public String getAge()
    {
        return this.age;
    }


    public String getEmail()
    {
        return this.email;
    }


    public String getSalary()
    {
        return this.salary;
    }


    public String getDepartment()
    {
        return this.department;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }

        User objAsUser = (User)obj;

        return this.firstName.equals(objAsUser.firstName)
        && this.lastName.equals(objAsUser.lastName)
        && this.age.equals(objAsUser.age)
        && this.email.equals(objAsUser.email)
        && this.salary.equals(objAsUser.salary)
        && this.department.equals(objAsUser.department);
    }
}
