logging('ajaxSentence.js', 'loaded');
loadSentence();

/**
 * フォームのAjax送信処理
 */
function loadSentence() {
    logging('loadSentence', 'start');

    // TODO : get from GET param
    var _url = 'http://localhost:8080/letter?id=2284';


    // 送信
    $.ajax({
        url: _url,
        type: 'GET',
        // data: $button.serialize(),

        // 送信前
        beforeSend: function(xhr, settings) {
            logging('loadSentence : ajax', 'beforeSend');
        },
        // 応答後
        complete: function(xhr, textStatus) {
            logging('loadSentence : ajax', 'complete');
        },

        // 通信成功時の処理
        success: function(result, textStatus, xhr) {
            logging('loadSentence : ajax', 'success');
            // 入力値を初期化
            logging('loadSentence : result' , result);
        },

        // 通信失敗時の処理
        error: function(xhr, textStatus, error) {
            logging('ajaxForm : ajaxError', error);
        }
    });
}