
from multiprocessing import Condition, connection
import pymongo
from sklearn import impute  

connection=pymongo.MongoClient("mongodb://localhost:27017")
mydb=connection["empDb"]
myemployee=mydb["employees"]

while True:
    print("  \n      MENU   ")
    print("1.Add an Employee ")
    print("2.View all Employee ")
    print("3.Search an Employee ")
    print("4.Delete an employee ")
    print("5.Update an Employee ")
    print("6.Employee name starts with")
    print("7.Exit ")
    option=int(input("Select an Option "))
    if option==1:
        print("Add option is selected")
        empCode=input("Enter the Employee code  ")
        empName=input("Enter the Employee name  ")
        empDesignation=input("Enter the employee Designation  ")
        data={"empCode":empCode,"empName":empName,"empDesignation":empDesignation}
        print(data)
        myemployee.insert_one(data)
    elif option==2:
        print("View option is selected")
        result=myemployee.find({},{"_id":0}).sort("empName",-1)
        for i in result:
            print(i)

    elif option==3:
        print("Search option is selected")
        empCode=input("Enter an employeeCode  ")
        data={"empCode":empCode}
        result=myemployee.find_one(data,{"_id":0})
        print(result)
    elif option==4:
        print("Delete option is selected")
        empCode=input("Enter the Employee code to be deleted  ")
        data={"empCode":empCode}
        myemployee.delete_one(data)
        print(" Data deleted Successfully")
    elif option==5:
        print("Update option is selected")
        empCode=input("Enter the employee Code to be updated    ")
        empName=input("Enter the employee name  ")
        empDesignation=input("Enter the designation ")
        setData={"empCode":empCode}
        newData={"$set":{"empName":empName,"empDesignation":empDesignation}}
        myemployee.update_one(setData,newData)
        print("Data updated successfully")
    elif option==6:
        ip=input("Enter the employee starting letter to be searched ")
        condition={"empName":{"$gte":ip}}
        result=myemployee.find(condition,{"_id":0})
        for i in result:
            print(i)
           

    else:
        break