;(function () {
    'use strict';

    var $form_add_task = $('.add-task')
        , $window = $(window)
        , $body = $('body')
        , task_list = []
        , $delete_task
        , $detail_task
        , $task_detail = $('.task-detail')
        , $task_detail_mask = $('.task-detail-mask')
        , current_index
        , $update_form
        , $task_detail_content
        , $task_detail_content_input
        , $checkbox_complete
        , $msg = $('.msg')
        , $msg_content = $msg.find('.msg-content')
        , $msg_confirm = $msg.find('.confirmed')
        , $alerter = $('.alert')
    init();

    $form_add_task.on('submit', addtaskFromSubmit);
    $task_detail_mask.on('click', hideTaskDetail);

    function $alert(arg) {
        if (!arg) {
            console.error('pop title is required');
        }
        var conf = {}
            , $box
            , $mask
            , $title
            , $content
            , $confirm
            , $cancel
            , dfd
            , confirmed
            , timer2
        ;

        dfd = $.Deferred();
        //dfd.resolve();
        if (typeof arg == 'string')
            conf.title = arg;
        else {
            conf = $.extend(conf, arg);
        }
        $box = $('<div>' +
            '<div class="pop-title">' + conf.title + '</div>' +
            '<div class="pop-content">' +
            '<div>' +
            '<button style="margin-right: 5px;" class="primary confirm">确定</button>' +
            '<button class="cancel">取消</button>' +
            '</div>' +
            '</div>' +
            '</div>')
            .css({
                color: '#444',
                position: 'fixed',
                width: 300,
                height: 100,
                padding: '10px',
                background: '#fff',
                'border-radius': 5,
                'box-shadow': '0 1px 2px rgba(0,0,0,.5)'
            })

        $title = $box.find('.pop-title').css({
            padding: '5px 10px',
            'font-weight': 800,
            'font-size': 18,
            'font-family': '微软雅黑',
            'text-align': 'center'
        })

        $content = $box.find('.pop-content').css({
            padding: '5px 10px',
            'text-align': 'center'
        })

        $confirm = $content.find('button.confirm');
        $cancel = $content.find('button.cancel');

        $mask = $('<div></div>')
            .css({
                position: 'fixed',
                top: 0,
                bottom: 0,
                left: 0,
                right: 0,
                background: 'rgba(0,0,0,.5)',
            })

        timer2 = setInterval(function () {
            if (confirmed !== undefined) {
                dfd.resolve(confirmed);
                clearInterval(timer2);
                dismisssAlert();
            }
        }, 50)
        $confirm.on('click', function () {
            confirmed = true;
        })
        $cancel.on('click', function () {
            confirmed = false;
        })
        $mask.on('click', function () {
            confirmed = false;
        })

        function dismisssAlert() {
            $mask.remove();
            $box.remove();
        };

        function adjustBoxPosition() {
            var window_width = window.innerWidth
                , window_height = window.innerHeight
                , box_width = $box.width()
                , box_height = $box.height()
                , move_x
                , move_y
            ;
            move_x = (window_width - box_width) / 2;
            move_y = (window_height - box_height) / 2 - 20;
            $box.css({
                left: move_x,
                top: move_y
            })

        }

        /*$( window ).resize(function(){
            adjustBoxPosition();
        })*/
        $window.on('resize', function () {
            adjustBoxPosition();
        })

        $mask.appendTo($body);
        $box.appendTo($body);
        $window.resize();
        return dfd.promise();
    }

    function listenMsgButton() {
        $msg_confirm.on('click', function () {
            hideMsg();
        })
    }

    // 提交添加的新任务
    function addtaskFromSubmit(e) {
        var new_task = {};
        // 禁用默认行为
        // alert(123)
        e.preventDefault();
        // 获取新task的值
        var $input = $(this).find('input[name=content]');
        var $time = $(this).find('input[name=time]');
        var $detail=$(this).find('textarea[name=detail]');
        new_task.content = $input.val();
        new_task.remind_date = $time.val();
        new_task.desc = $detail.val();
        if (!new_task.content) return;
        // console.log('new_task', new_task);
        // 存入新task
        if (addTask(new_task)) {
            //renderTaskList();
            $input.val(null);
        }
    }

    // 监听打开task详情事件
    function listenTaskDetail() {
        var index;
        $('.task-item').on('dblclick', function () {
            index = $(this).data('index');
            showTaskDetail(index);
        })
        $detail_task.on('click', function () {
            var $this = $(this);
            var $item = $this.parent().parent();
            index = $item.data('index');
            //console.log('$item.data(index)', index);
            showTaskDetail(index);
        })
    }

    // 监听完成task事件
    function listenCheckboxComplete() {
        $checkbox_complete.on('click', function () {
            var $this = $(this);
            var index = $this.parent().parent().data('index');
            var item = get(index);
            if (item.complete) {
                updateTask(index, {complete: false});
            } else {
                updateTask(index, {complete: true});
            }

        })
    }

    function get(index) {
        return store.get('task_list')[index];
    }

    // 查看task详情
    function showTaskDetail(index) {
        // 生成详情模板
        renderTaskDetail(index);
        current_index = index;
        $task_detail.show();
        $task_detail_mask.show();
    }

    // 更新task
    function updateTask(index, data) {
        if (index === undefined || !task_list[index]) return;
        //{complete: true|false}
        task_list[index] = $.extend({}, task_list[index], data);
        refreshTaskList();
    }


    // 隐藏详情模板
    function hideTaskDetail() {
        $task_detail.hide();
        $task_detail_mask.hide();
    }

    // 渲染详情模板
    function renderTaskDetail(index) {
        if (index === undefined || !task_list[index]) return;
        var item = task_list[index];
        var tpl = '<form>' +
            '<div class="content">' +
            item.content +
            '</div>' +
            '<div class="input-item">' +
            '<input style="display:none;" type="text" name="content" value="' + (item.content || '') + '">' +
            '</div>' +
            '<div>' +
            '<div class="desc input-item">' +
            '<textarea name="desc">' + (item.desc || '') + '</textarea>' +
            '</div>' +
            '</div>' +
            '<div class="remind input-item">' +
            '<label>提醒时间</label>' +
            '<input class="input-item datetime" name="remind_date" type="text" value="' + (item.remind_date || '') + '">' +
            '<div class="input-item"><button type="submit">更新</button></div>'
        '</div>' +
        '</form>';
        // 用新的模板替换旧的模板
        $task_detail.html(null);
        $task_detail.html(tpl);
        $('.datetime').datetimepicker();
        // 选中详情中的form元素，因为之后会使用其监听submit事件
        $update_form = $task_detail.find('form');
        $task_detail_content = $update_form.find('.content');
        $task_detail_content_input = $update_form.find('[name=content]');
        $task_detail_content.on('dblclick', function () {
            $task_detail_content_input.show();
            $task_detail_content.hide();
        })
        $update_form.on('submit', function (e) {
            e.preventDefault();
            var data = {};
            data.content = $(this).find('[name=content]').val();
            data.desc = $(this).find('[name=desc]').val();
            data.remind_date = $(this).find('[name=remind_date]').val();
            updateTask(index, data);
            hideTaskDetail();
        })

    }

    // 查找并且监听所有删除按钮的点击事件
    function listenTaskDelete() {
        $delete_task.on('click', function () {
            var $this = $(this);
            //找到删除按钮所在的任务元素
            var $item = $this.parent().parent();
            var index = $item.data('index');
            // 浏览器自带的提示框
            // var tmp = confirm('确定删除？');
            // tmp ? deleteTask(index) : null;
            $alert('确定删除吗？')
                .then(function (r) {
                    r ? deleteTask(index) : null;
                })
        })
    }

    // 添加task
    function addTask(new_task) {
        task_list.push(new_task);
        // 更新localStorage
        refreshTaskList();
        return true;
    }

    // 刷新localStorage数据。并更新view
    function refreshTaskList() {
        store.set('task_list', task_list);
        renderTaskList();
    }

    // 删除一条task
    function deleteTask(index) {
        if (index === undefined || !task_list[index]) return;

        delete task_list[index];
        refreshTaskList();
    }

    function init() {
        // store.clear();
        task_list = store.get('task_list') || [];
        listenMsgButton();
        if (task_list.length) {
            renderTaskList();
            taskRemideCheck();
        }
		$('.datetimepicker').datetimepicker();
		// var editor = new Simditor({
        //     toolbar: [
        //         'title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale',
        //         'color', '|', 'ol', 'ul', 'blockquote', 'code', 'table', '|', 'link',
        //         'image', 'hr', '|', 'alignment'
        //     ],
		// 	textarea: $('#editor')
        //
		// });
    }

    function taskRemideCheck() {
        //showMsg('lalallala');
        var current_timestamp;
        var timer = setInterval(function () {
            for (var i = 0; i < task_list.length; i++) {
                var item = get(i), task_timestamp;
                if (!item || !item.remind_date || item.informed) continue;
                // 当前时间转化为时间戳
                current_timestamp = (new Date()).getTime();
                //console.log('current_timestamp',current_timestamp)
                task_timestamp = (new Date(item.remind_date)).getTime();
                if (current_timestamp - task_timestamp >= 1) {
                    updateTask(i, {informed: true});
                    showMsg(item.content);
                }
            }
        }, 500)
    }

    function showMsg(msg) {
        if (!msg) return;
        $msg_content.html(msg);
        $alerter[0].play();
        $msg.show();
    }

    function hideMsg() {
        $msg.hide();
    }

    // 渲染全部的task模板
    function renderTaskList() {
        var $tasks_list = $('.tasks-list');
        var complete_items = [];
        $tasks_list.html('');
        for (var i = 0; i < task_list.length; i++) {
            var item = task_list[i];
            if (item && item.complete)
                complete_items[i] = item;
            else
                var $task = renderTaskItem(item, i);
            $tasks_list.prepend($task)
        }

        for (var j = 0; j < complete_items.length; j++) {
            $task = renderTaskItem(complete_items[j], j);
            if (!$task) continue;
            $task.addClass('completed');
            $tasks_list.append($task);
        }

        $delete_task = $('.action.delete');
        $detail_task = $('.action.detail');
        $checkbox_complete = $('.tasks-list .complete[type=checkbox]');
        // jQuery不会自动监听事件，需要我们手动绑定事件
        listenTaskDelete();
        listenTaskDetail();
        listenCheckboxComplete();
    }

    // 渲染一条task模板
    function renderTaskItem(data, index) {
        //使用（!index）会过滤index为0的情况，导致添加的第一条task无法渲染，遂改为（index === undefined）
        if (!data || index === undefined) return;
        var list_item_tpl =
            '<div class="task-item" data-index="' + index + '">' +
            '<span><input class="complete" ' + (data.complete ? 'checked' : '') + ' type="checkbox"></span>' +
            '<span class="task-content">' + data.content + '</span>' +
            '<span class="flor">' +
            '<span class="action delete">删除 </span>' +
            '<span class="action detail">详细</span>' +
            '</span>' +
            '</div>';
        return $(list_item_tpl);
    }
})();