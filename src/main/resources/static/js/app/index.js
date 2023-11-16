var main = {
    init : function () {

        var _this = this;

        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });

        $('#btn-save-cmt').on('click', function () {
            _this.save_cmt();
        });

        $('#btn-save-group').on('click', function () {
            _this.save_group();
        });

        $('#btn-apply').on('click', function () {
            _this.apply();
        });


        // jQuery DatePicker
        $(document).ready(function(){
            $('#startDate').datepicker({
                dateFormat: 'yy-mm-dd',
                onSelect: function(selectedDate) {
                    $('#endDate').datepicker('option', 'minDate', selectedDate);
                }
            });

            $('#endDate').datepicker({
                dateFormat: 'yy-mm-dd',
                onSelect: function(selectedDate) {
                    $('#startDate').datepicker('option', 'maxDate', selectedDate);
                }
            });
        });

        // BootStrap SmartWizard
        $(document).ready(function(){
            $('#smartwizard').smartWizard({
                selected: 0,
                theme: 'arrows',
                autoAdjustHeight:true,
                transitionEffect:'fade',
                showStepURLhash: false,
                onLeaveStep: function(obj, context){ //단계가 넘어갈 때마다 호출되는 콜백함수
                    if (context.toStep == context.steps.length) {
                        // 마지막 단계에서는 다음 버튼을 숨김
                        $(".sw-btn-next").hide();
                    } else {
                        // 마지막 단계가 아닌 경우 다음 버튼을 보여줌
                        $(".sw-btn-next").show();
                    }
                    return true;
                }
            });
        });

        // FullCalendar
        document.addEventListener('DOMContentLoaded', function() {
            var calendarEl = document.getElementById('calendar');
            var calendar = new FullCalendar.Calendar(calendarEl, {
              initialView: 'dayGridMonth'
            });
            calendar.render();
        });
    },

    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val(),
            category: $('#category').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('Saved successfully.');
            window.location.href = '/';
        }).fail(function (error) {
            alert('Access denied.'+JSON.stringify(error));
        });
    },

    update : function () {
        var data = {
            title: $('#title').val(),
            category: $('#category').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('Update completed.');
            window.location.href = '/posts/view/'+id;
        }).fail(function (error) {
            alert('Failed to update your post.'+JSON.stringify(error));
        });
    },

    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
        }).done(function() {
            alert('Deleted your post.');
            window.location.href = '/';
        }).fail(function (error) {
            alert('Failed to delete your post.'+JSON.stringify(error));
        });
    },

    save_cmt : function () {
        var data = {
            posts_id: $('#posts_id').val(),
            content: $('#cmt_content').val(),
        }

        //공백, 빈 문자열 체크
        if(!data.content || data.content.trim() === "") {
            alert("Please enter a comment.");
            return false;
        } else {
            $.ajax({
                type: 'POST',
                url: '/api/posts/' + data.posts_id + '/comments',
                dataType: 'JSON',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function () {
                alert('Saved your comment.');
                window.location.reload();
            }).fail(function (error) {
                alert('Failed to save your comment.'+JSON.stringify(error));
            });
        }
    },

    save_group : function () {

        var data = {
                category: $('input[name="category"]:checked').val(),
                stack: $('#stack').val(),
                startDate: $('#startDate').val(),
                endDate: $('#endDate').val(),
                name: $('#name').val(),
                leader: $('#leader').val(),
                headcount: $('#headcount').val(),
                headcountStatus: +$('#headcountStatus').val()
                }


        // 서버로 데이터 전송
        $.ajax({
            type: 'POST',
            url: '/api/v1/group',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('Saved successfully.');
            window.location.href = '/';
        }).fail(function (error) {
            alert('Access denied.'+JSON.stringify(error));
        });
    },

    apply : function () {
        var data = {
            applicants: $("userName").val()
        }
    $.ajax({
            type: 'POST',
            url: '/api/v1/group.apply',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('Applied.');
            window.location.href = '/';
        }).fail(function (error) {
            alert('Access denied.'+JSON.stringify(error));
        });
    }

};

main.init();
