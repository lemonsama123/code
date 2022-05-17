from faker import Faker
fake = Faker(locale='zh_CN')
set1 = {-1}
i = 0
wf = open('./train_ticket_booking_system/info', 'w', encoding='gbk')
while i <= 10:
    str1 = ""
    id1 = fake.random_number(digits=5)
    while id1 in set1 or (id1 < 10000 or id1 > 99999):
        id1 = fake.random_number(digits=5)
    set1.add(id1)
    str1 += str(id1) + " "
    str1 += fake.ssn() + " "
    str1 += ("1" if fake.boolean() else "0") + " "
    str1 += fake.name() + " "
    str1 += fake.phone_number() + " "
    str1 += fake.city_name() + " "
    str1 += fake.city_name() + " "
    str1 += fake.time(pattern='%H:%M') + " "
    str1 += fake.time(pattern='%H:%M') + " "
    time = fake.pyfloat()
    while 1000 < time or time < 50:
        time = fake.pyfloat()
    str1 += ('%.2f' % time) + " "
    isStu = fake.boolean()
    str1 += ("1" if isStu else "0") + " "
    if isStu:
        str1 += ('%s' % (fake.city_name() + "学院")) + " "
        str1 += str(fake.random_number(digits=10)) + " "
        time = fake.pyfloat()
        while 1 < time or time < 0:
            time = fake.pyfloat()
        str1 += ('%.2f' % time) + " "
    else:
        str1 += "无 "
        str1 += "无 "
        str1 += "0.0 "
    wf.write(str1)
    wf.writelines('\n')
    i = i + 1
wf.close()
