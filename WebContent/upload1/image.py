import requests
import re
import pymysql
db = pymysql.connest(host='127.0.0.1',port = 3306,db='db',user ='root'
                     ,password= 'root',charset='utf8')

cursor = db.cursor()
cursor.execute('select * from images')


#获取图片列表
def getImageList(page=1)：
    html = requests.get(   #获取网页中的源代码#
     'http://www.doutula.com/photo/list/?page={}'.format(page)).text
    reg=r'data-original="(.*?)".*?alt="(.*?)"'
    reg = re.compile(reg,re.S)
    imagesList = re.findall(reg,html)
    #print(imagesList)
    for i in imagesList:
        cursor.execute("insert into images('name','imageUrl') values ('{}','{}')
                       ".format(i[1],i[0]))
                   print ('正在保存%s：'%i[1])
                       db.comit()
                       
for i in rang(1,1000)
  print ('第{}页')
  getImageList()  
