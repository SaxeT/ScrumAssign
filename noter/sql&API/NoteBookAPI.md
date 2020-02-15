# 笔记本API

## 查

## /notebook/list

- 参数  `x-www-form-urlencoded`

  ```
  userId:1
  ```

  

- 返回

  ```
  {
      "result": true,
      "message": "已成功找到全部的笔记本",
      "data": [
          {
              "bookname": "英语学习",
              "description": "学习英语 day day up",
              "id": 1,
              "uid": 1
          },
          {
              "bookname": "美食",
              "description": "每天都要吃吃吃",
              "id": 2,
              "uid": 1
          },
          {
              "bookname": "旅行",
              "description": "沿途人文风景",
              "id": 3,
              "uid": 1
          }
      ]
  }
  ```

  



## 增

### /notebook/add

- 参数  `x-www-form-urlencoded`

  ```
  bookname:健身
  description:锻炼身体，生命在于运动
  userId:2
  ```

  

- 返回

  ```
  {
      "result": true,
      "message": "新增笔记本成功！",
      "data": {
          "bookname": "健身",
          "description": "锻炼身体，生命在于运动",
          "id": 8,
          "uid": 2
      }
  }
  
  {
      "result": false,
      "message": "笔记本已经存在!",
      "data": null
  }
  ```



## 改



### /notebook/modify

- 参数

  ```
  ID:2
  oldBookname:美食
  newBookname:美食记
  oldDescription:
  newDescription:骗吃骗喝
  userId:1
  ```

- 返回

  ```
  {
      "result": true,
      "message": "笔记本修改成功!",
      "data": {
          "bookname": "美食记",
          "description": "骗吃骗喝",
          "id": 2,
          "uid": 1
      }
  }
  ```




- 参数2

```

  ID:1
  oldBookname:旅行
  newBookname:美食记
  oldDescription:
  newDescription:骗吃骗喝
  userId:1

```


- 返回2

```

  {
      "result": false,
      "message": "笔记本ID与笔记本name冲突，修改失败",
      "data": null
  }

```


- 参数3

```

  ID:1
  oldBookname:旅行
  newBookname:美食记
  oldDescription:
  newDescription:骗吃骗喝
  userId:2

```


- 返回3

```

  {
      "result": false,
      "message": "不拥有对本笔记的访问权限",
      "data": null
  }

```
  



# 删

## /notebook/delete

- 参数

```
  ID:8
  bookname:吃喝玩乐
  userId:2
```

  

- 返回

```
  {
      "result": true,
      "message": "删除本修改成功!",
      "data": null
  }
```

  