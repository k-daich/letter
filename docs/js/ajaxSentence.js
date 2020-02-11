logging('ajaxSentence.js', 'loaded');

var TYPE = {
    noInput: 1,
    radio: 2,
    select: 3,
    checkBox: 4,
    textBox: 5,
    textArea: 6
}

// グローバル変数として表示情報を保持させる
var dispInfoArray = loadSentence();

/**
 * フォームのAjax送信処理
 */
function loadSentence() {
    logging('loadSentence', 'start');
    var ajax_res;

    // TODO : get from GET param
    var _url = '/app/letter?sentence_id=903';

    // 送信
    $.ajax({
        url: _url,
        type: 'GET',

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
            ajax_res = result;
            // 入力値を初期化
            loggingObj('loadSentence : result' , result);
        },

        // 通信失敗時の処理
        error: function(xhr, textStatus, error) {
            logging('ajaxForm : ajaxError', error);
        }
    });
    return ajax_res;
}