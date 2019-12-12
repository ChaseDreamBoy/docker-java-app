function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    return window.location.protocol + '//' + window.location.host + '/' + webName;//+ '/';   
}

$(function () {
    listMysqlData();
});

function setRedisValue() {
    var value = $("#setRedisValueInput").val();
    $.ajax({
        type: "POST",
        async: false,
        url: getRootPath() + "/redis/setValue?value=" + value,
        error: function () {
            alert('请求失败');
        },
        success: function (data) {
            alert(data);
            $("#setRedisValueInput").val("");
        }
    });
}

function getRedisValue() {
    $.ajax({
        type: "GET",
        async: false,
        url: getRootPath() + "/redis/value",
        error: function () {
            alert('请求失败');
        },
        success: function (data) {
            $("#getRedisValueSpan").html(data);
        }
    });
}

function addMysqlData() {
    var name = $("#addMysqlDataInput").val();
    $.ajax({
        type: "POST",
        async: false,
        url: getRootPath() + "/jpa/save?name=" + name,
        error: function () {
            alert('请求失败');
        },
        success: function (data) {
            alert(data);
            listMysqlData();
            $("#addMysqlDataInput").val("");
        }
    });
}

function listMysqlData() {
    $.ajax({
        type: "GET",
        async: false,
        url: getRootPath() + "/jpa/list",
        error: function () {
            alert('请求失败');
        },
        success: function (data) {
            $("#listMysqlDataBody").html("");
            data.forEach(function (obj, index) {
                $("#listMysqlDataBody").append('<tr><td>' + obj.id + '</td>'
                    + '<td>' + obj.name + '</td>'
                    + '<td><button onclick="delMysqlData(' + obj.id + ')">删除</button></td></tr>');
            });

        }
    });
}

function delMysqlData(id) {
    $.ajax({
        type: "DELETE",
        async: false,
        url: getRootPath() + "/jpa/del/" + id,
        error: function () {
            alert('请求失败');
        },
        success: function (data) {
            alert(data);
            listMysqlData();
        }
    });
}