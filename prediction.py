import numpy as np
import pandas as pd
from sklearn.ensemble import RandomForestClassifier
from sklearn.datasets import make_classification
from sklearn import metrics
import pickle
dataLocation="/home/jadid/All/study/academic/spring 2022/os lab/after mid/src/src/data.csv"
file = pd.read_csv(dataLocation)
filename = '/home/jadid/All/study/academic/spring 2022/os lab/after mid/src/src/finalized_model.pkl'
loaded_model = pickle.load(open(filename, 'rb'))
n=len(file)-1
age=file.iloc[n]["age"]
systolicBp=file.iloc[n]["systolicBp"]
diastolicBp=file.iloc[n]["diastolicBp"]
bloodSugure=file.iloc[n]["bloodSugure"]
bodyTemp=file.iloc[n]["bodyTemp"]
heartRate=file.iloc[n]["heartRate"]
p=[[age,systolicBp,diastolicBp,bloodSugure,bodyTemp,heartRate]]
predAns=loaded_model.predict(p)[0]
file.at[len(file)-1,'prediction']= predAns
print(file)
file.reset_index(drop=True)
file.to_csv(dataLocation,index=False)

print(predAns)