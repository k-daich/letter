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
const dispSpeed = 90; // 1文字を表示する際のミリ秒
/**
 * アニメーション
 */
var animate = {
    /*
     * アニメーションの実行手続き
     */
    execute: function(element, sentence) {
        animate.nbspSet(element, sentence.split(/\n/));
        logging('replStr', sentence.replace(/\n/g, ''));
        animate.dispLikeTypeWriter(element, 0, Array.from(sentence.replace(/\n/g, '')));
    },

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
     * タイプライターのように一文字ずつ表示させる
     */
    dispLikeTypeWriter: function(element, index, replcStr) {
        if (replcStr.length == index) return;
        // "全角一文字"⇔"nbsp2つ"を置換
        if (isZenkaku(replcStr[index])) {
            element.innerHTML = element.innerHTML.replace('&nbsp;&nbsp;', replcStr[index]);
        // "半角一文字"⇔"nbsp1つ"を置換
        } else {
            element.innerHTML = element.innerHTML.replace('&nbsp;', replcStr[index]);
        }
        setTimeout(animate.dispLikeTypeWriter, dispSpeed, element, ++index, replcStr);
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
    animate.execute(this.subtitlesEle, sentences[currentDispTextIndex++]);
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