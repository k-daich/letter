var TYPE = {
    noInput: 1,
    radio: 2,
    select: 3,
    checkBox: 4,
    textBox: 5,
    textArea: 6
}

var dispInfoArray = [{
        type: TYPE.textArea,
        initValue: "こんにちは。",
        label: "挨拶",
        cols: 25,
        rows: 5,
        maxLength: 100,
        text: "textareaテスト用文言。\n\
はい or いいえ"
    },
    {
        type: TYPE.textBox,
        inputs: [{
                initValue: "田中",
                label: "姓",
                maxLength: 10
            },
            {
                initValue: "太郎",
                label: "名",
                maxLength: 12
            },
            {
                initValue: "たなたろ",
                label: "ニックネーム",
                maxLength: 15
            }
        ],
        text: "textboxテスト用文言。\n\
はい or いいえ"
    },
    {
        type: TYPE.checkBox,
        choice: [{
                value: "head",
                label: "頭"
            },
            {
                value: "stomach",
                label: "腹"
            },
            {
                value: "tail",
                label: "尾"
            }
        ],
        text: "checkboxテスト用文言。\n\
はい or いいえ"
    },
    {
        type: TYPE.select,
        choice: [{
                value: "head",
                label: "頭"
            },
            {
                value: "stomach",
                label: "腹"
            },
            {
                value: "tail",
                label: "尾"
            }
        ],
        text: "selectテスト用文言。\n\
はい or いいえ"
    },
    {
        type: TYPE.radio,
        choice: [{
                value: "yes",
                label: "はい"
            },
            {
                value: "no",
                label: "いいえ"
            }
        ],
        text: "radioテスト用文言。\n\
はい or いいえ"
    },
    {
        type: TYPE.noInput,
        text: "テスト用文言。\n\
改行もOK。\n\
1バイトと2バイト文字が混在しようが問題無し。"
    },
    {
        type: TYPE.noInput,
        text: "入力無しパターンは問題なく表示できる。"
    },
    {
        type: TYPE.radio,
        choice: [{
                value: "yes",
                label: "はい"
            },
            {
                value: "no",
                label: "いいえ"
            }
        ],
        text: "radioテスト用文言。\n\
はい or いいえ"
    }
];