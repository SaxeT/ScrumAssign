$(function () {
    //隐藏错误提示框
    $('.alert-danger').css("display", "none");

    //modal绑定hide事件
    $('#modalAdd').on('hide.bs.modal', function () {
        reset();
    })
    $('#modalEdit').on('hide.bs.modal', function () {
        reset();
    })

});

/**
 * 重置 清空Modal输入框的内容
 */
function reset() {
    //隐藏错误提示框
    $('.alert-danger').css("display", "none");
    //清空数据
    $('#description').val('');
    $('#bookname').val('');
    $('#userId').val(0);
}

/**
 * boostrap table 重新加载
 */
function reload() {
    reset();
    // window.location.href = "notebook.html";
}


function showErrorInfo(info) {
    $('.alert-danger').css("display", "block");
    $('.alert-danger').html(info);
}

/**
 * 判空
 */
function isNull(obj) {
    if (obj == null || obj == undefined || obj.trim() == "") {
        return true;
    }
    return false;
}


function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");

    if (arr = document.cookie.match(reg))
        return unescape(arr[2]);
    else
        window.location.href = "login.html";
};

function setCookie(name,value,expires){
    let exp = new Date();
    exp.setTime(exp.getTime() + expires*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}

/* 新增笔记本 */
function userAdd() {
    reset();
    $('#modalAddTitle').html('新增笔记本');
    $('#modalAdd').modal('show');
}

/**
 * 数据验证
 */
function validObjectForAdd() {
    var userName = $('#bookname').val();
    if (isNull(userName)) {
        showErrorInfo("用户名不能为空!");
        return false;
    }
    return true;
}

//绑定modal上的保存按钮
$('#saveButton').click(function () {
    //验证数据
    if (validObjectForAdd()) {
        //一切正常后发送网络请求
        //ajax
        var bookname = $("#bookname").val();
        var description = $("#description").val();
        var userId = getCookie('id');
        var data = {"bookname": bookname, "description": description, "userId": userId};
        $.ajax({
            type: 'POST',//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: '/notebook/add' ,//url
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            data: data,
            success: function (result) {
                console.log(result);//打印服务端返回的数据
                if(result.result===true){
                    swal("新增成功 ", {
                        icon : "success",
                        buttons: {
                            confirm: {
                                text: "Yee",
                                className : 'btn btn-success'
                            },
                        },
                    }).then(function(){
                        window.location.href = "notebook.html";
                    });
                }else{
                    swal("新增失败!", result.message, {
                        icon : "error",
                        buttons: {
                            confirm: {
                                className : 'btn btn-danger'
                            }
                        },
                    });
                }
            },
            error: function () {
                reset();
                swal("操作失败", {
                    icon: "error",
                });
            }
        });

    }
});



/* 修改笔记本  */
function userEdit() {
    var row=$("#booktable").bootstrapTable('getSelections');
    if(row.length < 1) {
        swal("请先选中一行记录", {
            icon: "error",
        });
    }

    if(row.length > 1) {
        swal("不允许选中多行", {
            icon: "error",
        });
    }
    var newBookname = row[0].bookname;
    var newDescription = row[0].description;


    $('#newBookname').val(newBookname);
    $('#newDescription').val(newDescription );


    $('#modalEditTitle').html('修改笔记本');
    $('#modalEdit').modal('show');
}


//绑定modal上的编辑按钮
$('#editButton').click(function () {
    //验证数据
    if (validObjectForEdit()) {
        var newBookname = $("#newBookname").val();
        var newDescription = $("#newDescription").val();
        var userId = getCookie('id');
        var row=$("#booktable").bootstrapTable('getSelections');
        var ID = row[0].id;
        var data = {"ID":ID, "newBookname": newBookname, "newDescription": newDescription,
            "oldBookname": newBookname, "oldDescription" : newDescription ,"userId": userId };
        $.ajax({
            type: 'POST',//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: '/notebook/modify',//url
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            data: data,
            success: function (result) {
                console.log(result);//打印服务端返回的数据
                if(result.result===true){
                    swal("修改成功 ", {
                        icon : "success",
                        buttons: {
                            confirm: {
                                text: "Yee",
                                className : 'btn btn-success'
                            },
                        },
                    }).then(function(){
                        window.location.href = "notebook.html";
                    });
                }else{
                    swal("修改失败!", result.message, {
                        icon : "error",
                        buttons: {
                            confirm: {
                                className : 'btn btn-danger'
                            }
                        },
                    });
                }

            },
            error: function () {
                reset();
                swal(result.message, {
                    icon: "error",
                });

            }
        });

    }
});

function validObjectForEdit() {
    return true;
}


/* 删除笔记本  */
/**
 * 用户删除
 */
function userDel() {

    var row=$("#booktable").bootstrapTable('getSelections');
    if(row.length < 1) {
        swal("请先选中一行记录", {
            icon: "error",
        });
    }
    var ID = row[0].id;
    var bookname = row[0].bookname;
    var userId = getCookie('id');
    var data = {"ID": ID, "bookname": bookname, "userId": userId};

    swal({
        title: "删除确认",
        text: "确定要删除笔记本: " + bookname + " ?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    }).then((flag) => {
            if(flag) {
                $.ajax({
                    type: "POST",
                    url: "/notebook/delete",
                    contentType: "application/x-www-form-urlencoded;charset=utf-8",
                    data: data,
                    success: function (r) {
                        console.log(r);
                        if(r.result===true){
                            swal("删除成功 ", {
                                icon : "success",
                                buttons: {
                                    confirm: {
                                        text: "Yee",
                                        className : 'btn btn-success'
                                    },
                                },
                            }).then(function(){
                                window.location.href = "notebook.html";
                            });
                        }else{
                            swal("删除失败", r.message, {
                                icon : "error",
                                buttons: {
                                    confirm: {
                                        className : 'btn btn-danger'
                                    }
                                },
                            });
                        }

                    }
                });
            }
        }
    );
}


/* 新增笔记  */
function  addNote() {
    var row=$("#booktable").bootstrapTable('getSelections');
    if(row.length < 1) {
        swal("请先选中一个笔记本", {
            icon: "error",
        });
    }

    var ID = row[0].id;
    var bookname = row[0].bookname;

    swal({
        title: "选择确认",
        text: "选择笔记本: " + bookname + " ?",
        icon: "success",
        buttons: true,
        dangerMode: true,
    }).then((flag) => {
            if(flag) {

                setCookie("notebookid",ID , 1000);
                window.location.href = "newnote.html";
            }
        }
    );


}

