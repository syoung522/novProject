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

};

main.init();
