var currentDispTextIndex = 0;

function nextText() {
    logging('nextText.js', 'start');
    var subtitlesEle = document.getElementById('subtitles');
    loggingObj('subtitlesEle', subtitlesEle);

    loadScript('/git/letter/docs/js/sentence/20200116.js', function() {
        // subtitles-wrapをクリックされた場合のイベントリスナーを追加
        document.getElementById('subtitles-wrap').addEventListener("mousedown", { subtitlesEle: subtitlesEle, handleEvent: mdown }, false);
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
    /*
     * アニメーションの実行手続き
     */
    run: function(element, sentence) {
        // 処理中フラグを立てる
        animate.isRunning = true;
        animate.nbspSet(element, sentence.split(/\n/));
        logging('replStr', sentence.replace(/\n/g, ''));
        animate.dispLikeTypeWriter(element, 0, Array.from(sentence.replace(/\n/g, '')));
    },

    /*
     * 表示する文字分だけのnbspを設定する
     */
    nbspSet: function(element, text_array) {
        var init_html = '';
        for (index in text_array) {
            var textByte = text_array[index].length + amountOfZenkaku(text_array[index]);
            init_html = init_html + ((index == 0) ? '' : '<br>') + ''.padStart(textByte * '&nbsp;'.length, '&nbsp;');
        }
        logging('init_html', init_html);
        // 初期表示：表示する文章と同じ文字数の半角スペースを設定
        element.innerHTML = init_html;
    },

    /**
     * タイプライターのようにnbspを一文字ずつ置換して文字を表示させていく
     */
    dispLikeTypeWriter: function(element, index, replcStr) {
        // 二重起動した場合 OR 全ての表示が完了した場合
        if (animate.isDuplicate || replcStr.length == index) {
            // 処理中フラグを落とす
            animate.isRunning = false;
            return;
        }
        // "全角一文字"⇔"nbsp2つ"を置換
        if (isZenkaku(replcStr[index])) {
            element.innerHTML = element.innerHTML.replace('&nbsp;&nbsp;', replcStr[index]);
            // "半角一文字"⇔"nbsp1つ"を置換
        } else {
            element.innerHTML = element.innerHTML.replace('&nbsp;', replcStr[index]);
        }
        setTimeout(animate.dispLikeTypeWriter, dispSpeed, element, ++index, replcStr);
    },

    /**
     * 即時に文字を全表示する
     */
    allDisp: function(element, sentence) {
        element.innerHTML = sentence.replace(/\n/g, '<br>');
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
    loggingObj('subtitlesEle', this.subtitlesEle);
    // アニメーションが実行中の場合
    if (animate.isRunning) {
        // 二重起動フラグを立てる
        animate.isDuplicate = true;
        // 全ての文字を即時表示させる
        // ※アニメーションの処理中であることを考慮し、ループ時間+αミリ秒だけ待機してから実行する
        setTimeout(animate.allDisp, dispSpeed + 100, this.subtitlesEle, sentences[currentDispTextIndex-1]);
    }
    // アニメーションが実行中でない場合
    else {
        animate.run(this.subtitlesEle, sentences[currentDispTextIndex++]);
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