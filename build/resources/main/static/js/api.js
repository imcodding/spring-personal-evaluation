const API = (function () {
    return {
        get: function (url, params) {
            API.ajax(url, 'get', params);
        },
        post: function (url, params) {
            API.ajax(url, 'post', params);
        },
        ajax: function (url, method, params) {
            let options = {
                type: method.toUpperCase(),
                url: url,
                dataType: 'json',
                success: function (data, status) {
                    if (params.success !== undefined) {
                        params.success(data, this.data);
                    }
                },
                error: function (xhr) {
                    console.log(xhr)
                }
            }
            return $.ajax($.extend(options, params.options));
        }
    }
})();