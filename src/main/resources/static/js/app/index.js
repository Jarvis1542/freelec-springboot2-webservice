var index = {
    init: function() {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function() {
           _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        })
    },

    save: function() {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    update: function () {
        console.log("title : " + title);
        console.log("content : " + content);
        var data = {
            title: $('#title').val(),
            content : $('#content').val()
        };
        console.log("title : " + title);
        console.log("content : " + content);
        var id = $('#id').val();
        console.log("id : " + id);
        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },

    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

index.init();

// 브라우저는 공용 공간이기 때문에 여러사람이 참여하는 프로젝트에는 중복된 함수가 자주 발생
// -> 모든 함수 이름을 확인하면서 만들 수 없다.
// 그래서 index 객체 안에서만 작동하게 만들어서 다른 JS와 겹치지 않게 한다.