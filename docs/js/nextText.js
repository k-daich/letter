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
var currentText;
var dispCount = 0; // 現在表示されている文字数
const dispSpeed = 100; // 1文字を表示する際のミリ秒
/**
 * アニメーション
 */
var animate = {
    /**
     * タイプライターのように一文字ずつ表示させる
     */
    dispLikeTypeWriter: function(element, sentence) {
        if (dispCount > sentence.length) {
            logging('LoopEnd');
            dispCount = 0;
            return;
        }

        currentText = currentText.replace('&nbsp;' , sentence.charAt(dispCount));
//        currentText = repalaceAt(currentText, dispCount, sentence.charAt(dispCount));
        logging('count : currentText', dispCount + ':' + currentText + 'D');

        // テキストフィールドにデータを渡す処理
        element.innerHTML = currentText;
        dispCount++;

        setTimeout(animate.dispLikeTypeWriter, dispSpeed, element, sentence);
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
    // 初期表示：表示する文章と同じ文字数の半角スペースを設定
    currentText = ''.padStart(sentences[currentTextIndex].length * '&nbsp;'.length, '&nbsp;');
    this.subtitlesEle.innerHTML = currentText;
    logging('currentText.length', currentText.length);
    animate.dispLikeTypeWriter(this.subtitlesEle, sentences[currentTextIndex++]);
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