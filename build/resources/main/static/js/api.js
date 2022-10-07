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
            if(method === 'post') {
                try {
                    if(params.data) options.data = JSON.stringify(params.data);
                    let o = params.data;
                    if(o && typeof o === 'object' && o != null) {
                        options.contentType = 'application/json; charset=utf-8';
                    }
                } catch (e) {
                    if (params.data) options.data = params.data;
                }
            }
            return $.ajax($.extend(options, params.options));
        }
    }
})();