var currentTextIndex = 0;

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
// マウスダウンした時に発火
function mdown(event) {
    logging('mdown', 'start');
    loggingObj('subtitlesEle', this.subtitlesEle);
    dispLikeTypeWriter(this.subtitlesEle, sentences[currentTextIndex++]);
}



/**
 * タイプライターのように一文字ずつ表示させる
 */
var dispCount = 0; // 現在表示されている文字数
const dispSpeed = 300; // 1文字を表示する際のミリ秒
function dispLikeTypeWriter(element, sentence) {
    dispCount++;
    logging('count : sentence', dispCount + ':' + sentence);

    if (dispCount > sentence.length) {
        logging('end');
        dispCount = 0;
        return;
    }
    var type = sentence.substring(0, dispCount);
    // テキストフィールドにデータを渡す処理
    element.innerHTML = type;

    var rep = setTimeout(dispLikeTypeWriter(element, sentence), dispSpeed);
}


/**
 * 以降、Util
//
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