logging('ajaxForm.js', 'loaded');

/**
 * フォームのAjax送信処理
 */
function addAjaxFormEvent() {
	$('#i_subsForm_btn').on('click', function() {
    logging('ajaxForm: submit', 'start');
    // HTMLでの送信をキャンセル
    // event.preventDefault();

    // 送信ボタンを取得
    var $button = $(this);

    // 送信ボタンを取得
    var $form = $button.closest('form');
    loggingObj('ajaxForm : $button', $button);
    loggingObj('ajaxForm : $form', $form);

    // 送信
    $.ajax({
        url: $button.attr('ajax_url'),
        type: $button.attr('method'),
        data: $button.serialize(),

        // 送信前
        beforeSend: function(xhr, settings) {
            logging('ajaxForm : ajax', 'beforeSend');
            // ボタンを無効化し、二重送信を防止
            $button.attr('disabled', true);
        },
        // 応答後
        complete: function(xhr, textStatus) {
            logging('ajaxForm : ajax', 'complete');
            // ボタンを有効化し、再送信を許可
            $button.attr('disabled', false);
        },

        // 通信成功時の処理
        success: function(result, textStatus, xhr) {
            logging('ajaxForm : ajax', 'success');
            // 入力値を初期化
            $form.html(result);
        },

        // 通信失敗時の処理
        error: function(xhr, textStatus, error) {
            logging('ajaxForm : ajax', 'error');
        }
    });
});
}