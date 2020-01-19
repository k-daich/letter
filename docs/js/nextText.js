var currentDispTextIndex = 0;

function nextText() {
    logging('nextText.js', 'start');
    animate.textEle = document.getElementById('i_subtitles');
    loggingObj('animate.textEle', animate.textEle);
    animate.formEle = document.getElementById('i_subsForm');
    loggingObj('animate.formEle', animate.formEle);

    loadScript('/git/letter/docs/js/sentence/20200119.js', function() {
        // subtitles-wrapをクリックされた場合のイベントリスナーを追加
        document.getElementById('i_subtitles-wrap').addEventListener("mousedown", mdown, false);
    });
}

/**
 * 以降、ファンクション
 */
const dispSpeed = 50; // 1文字を表示する際のミリ秒
/**
 * アニメーション
 */
var animate = {
    // 処理中フラグ
    isRunning: false,
    // 二重起動フラグ
    isDuplicate: false,
    // 表示する情報
    dispInfo: null,
    // テキスト表示箇所
    textEle: null,
    // フォーム表示箇所
    formEle: null,
    /*
     * アニメーションの実行手続き
     */
    run: function() {
        // 処理中フラグを立てる
        animate.isRunning = true;
        animate.nbspSet(animate.dispInfo.text.split(/\n/));
        logging('replStr', animate.dispInfo.text.replace(/\n/g, ''));
        animate.dispLikeTypeWriter(0, Array.from(animate.dispInfo.text.replace(/\n/g, '')));
    },

    /*
     * 表示する文字分だけのnbspを設定する
     */
    nbspSet: function(text_array) {
        var init_html = '';
        for (index in text_array) {
            var textByte = text_array[index].length + amountOfZenkaku(text_array[index]);
            init_html = init_html + ((index == 0) ? '' : '<br>') + ''.padStart(textByte * '&nbsp;'.length, '&nbsp;');
        }
        logging('init_html', init_html);
        // 初期表示：表示する文章と同じ文字数の半角スペースを設定
        animate.textEle.innerHTML = init_html;
    },

    /**
     * タイプライターのようにnbspを一文字ずつ置換して文字を表示させていく
     */
    dispLikeTypeWriter: function(index, replcStr) {
        // 二重起動した場合 OR 全ての表示が完了した場合
        if (animate.isDuplicate || replcStr.length == index) {
            // フォームを表示する
            animate.dispForm();
            // 処理中フラグを落とす
            animate.isRunning = false;
            return;
        }
        // "全角一文字"⇔"nbsp2つ"を置換
        if (isZenkaku(replcStr[index])) {
            animate.textEle.innerHTML = animate.textEle.innerHTML.replace('&nbsp;&nbsp;', replcStr[index]);
            // "半角一文字"⇔"nbsp1つ"を置換
        } else {
            animate.textEle.innerHTML = animate.textEle.innerHTML.replace('&nbsp;', replcStr[index]);
        }
        setTimeout(animate.dispLikeTypeWriter, dispSpeed, ++index, replcStr);
    },

    /**
     * 即時に文字を全表示する
     */
    dispForm: function() {
        switch (animate.dispInfo.type) {
            case TYPE.noInput:
                logging('dispForm', 'TYPE.noInput');
                break;
            case TYPE.radio:
                logging('dispForm', 'TYPE.radio');
                break;
            case TYPE.select:
                logging('dispForm', 'TYPE.select');
                break;
            case TYPE.textBox:
                logging('dispForm', 'TYPE.textBox');
                break;
            case TYPE.textArea:
                logging('dispForm', 'TYPE.textArea');
                break;
            default:
                logging('dispForm', 'TYPE is unExpected : ' + animate.dispInfo.type);
                break;
        }
    },

    /**
     * 即時に文字を全表示する
     */
    allDisp: function() {
        animate.textEle.innerHTML = animate.dispInfo.text.replace(/\n/g, '<br>');
        // 二重起動フラグを落とす
        animate.isDuplicate = false;
    }
}

/**
 * 指定位置の文字を入れ替える
 */
function repalaceAt(str, index, char) {
    return str.slice(0, index) + char + str.slice(index + 1, str.length);
}

// マウスダウンした時に発火
function mdown(event) {
    logging('mdown', 'start');
    // 二重起動中は何もしない
    if (animate.isDuplicate) {
        return;
    }
    // アニメーションが実行中の場合
    else if (animate.isRunning) {
        // 二重起動フラグを立てる
        animate.isDuplicate = true;
        // 全ての文字を即時表示させる
        // ※アニメーションの処理中であることを考慮し、ループ時間+αミリ秒だけ待機してから実行する
        setTimeout(animate.allDisp, dispSpeed + 100);
    }
    // 上記以外
    else {
        // 現在の表示が文章の最後だった場合は処理終了
        if (dispInfoArray.length == currentDispTextIndex) return;
        animate.dispInfo = dispInfoArray[currentDispTextIndex++];
        animate.run();
    }
}

/**
 * 以降、Util
 */
function amountOfZenkaku(str) {
    logging('amountOfZenkaku : str', str);
    logging('amountOfZenkaku : han_Len', str.replace(/[^\x01-\x7E\xA1-\xDF]/g, '').length);
    return str.length - str.replace(/[^\x01-\x7E\xA1-\xDF]/g, '').length;
}

function isZenkaku(char) {
    return (char.match(/^[^\x01-\x7E\xA1-\xDF]+$/)) ? true : false;
}
/**
 * ログUtil
 */
function logging(processName, message) {
    console.log('[' + processName + '] ' + message);
}
var loggingMarkCount = 0;
/**
 * ログUtil(目立つラインをつけて目印にする)
 */
function loggingMark(message) {
    console.log(++loggingMarkCount + '----------------------------------------- ' + message + ' ----------------------------------------- ');
}

/**
 * ログUtil(オブジェクトの内容出力)
 */
function loggingObj(processName, object) {
    console.log('[' + processName + '] ');
    console.dir(object);
}