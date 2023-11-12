from csv import writer

age = int(input("age: "))
systolicBp = 113
diastolicBp = 76
bloodSugure = 8
bodyTemp = int(input("body temp : "))
heartRate = int(input("heart rate: "))

List = [age, systolicBp, diastolicBp, bloodSugure, bodyTemp, heartRate, -1]
with open('data.csv', 'a') as f_object:

    writer_object = writer(f_object)

    # Pass the list as an argument into
    # the writerow()
    writer_object.writerow(List)

    # Close the file object
    f_object.close()