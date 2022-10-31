
from flask import Flask, render_template,request
from matplotlib.pyplot import get
import pymongo
from sklearn import impute  
connection=pymongo.MongoClient("mongodb://localhost:27017")
mydb=connection["empDb"]
myemployee=mydb["employees"]

app = Flask(__name__)


@app.route("/")
def home():
    return render_template("employee1.html")

@app.route("/read",methods=["POST"])
def read():
    if(request.method=="POST"):
        empCode=request.form.get("ecode")
        empName=request.form.get("ename")
        empDesignation=request.form.get("edesig")
        data={"empCode":empCode,"empName":empName,"empDesignation":empDesignation}
        print(data)
        myemployee.insert_one(data)
        return render_template("employee1.html")

    else:
        return("Invalid")

@app.route("/view")
def view():
    result=myemployee.find({},{"_id":0}).sort("empName")
    datalist=[]
    for i in result:
        datalist.append(i) 

    return render_template("view.html",data=datalist)



app.run()
