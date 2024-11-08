### 構造理解
自分の理解
1. どういう状況か
    1. ある処理の制御を行いたい場合
2. どういう問題か
    1. 利用側が制御をしないといけなくなり、コードが複雑になる
3. どういう解決策か
    1. 利用側からは見えないように間に挟まる役割を入れる

↓

claude.aiの説明
1. どういう状況か
   1. あるオブジェクト（実オブジェクト）へのアクセスを制御したい場合
   2. 実オブジェクトの生成コストが高く、必要な時だけ生成したい場合
   3. 実オブジェクトへのアクセス前後に特別な処理を行いたい場合
2. どういう問題か
   1. 実オブジェクトへの直接のアクセスを許可すると、アクセス制御が難しくなる 
   2. 実オブジェクトの生成コストが高い場合、不必要なオーバーヘッドが発生する
   3. 実オブジェクトへのアクセス前後の処理を実オブジェクト自身に実装すると、実オブジェクトの責務が増えてしまう
3. どういう解決策か 
   1. 実オブジェクトと同じインターフェースを持つProxyオブジェクトを作成する
   2. クライアントはProxyオブジェクトを通じて実オブジェクトにアクセスする
   3. Proxyオブジェクトが実オブジェクトへのアクセスを制御し、必要な処理を行う
   4. Proxyオブジェクトの種類には、仮想Proxy、リモートProxy、保護Proxy、スマートリファレンスなどがある


↓\
↓

再解釈
1. どういう状況か
   1. あるオブジェクト生成や処理の制御など行いたい場合 
2. どういう問題か
   1. アクセス制御や生成コストからのオーバーヘッド、責務の不明確化が発生してしまう
3. どういう解決策か
   1. Proxyにある程度行いたいことを隠して、利用側はProxyを介して処理を行う
   2. アクセス制御や必要に応じた生成、不要な責務の引き受けなどを行うイメージ


ある処理に集中したいが、それ以外にもやることがある時に有効な手段っぽい。\
AOPやDIも似た感じ。共通したログやエラーハンドリング辺りで同じ話が出てきた気がする。\
[今こそ知りたいSpring DI x AOP #jsug | ドクセル](https://www.docswell.com/s/MasatoshiTada/Z818E5-spring-di-aop-for-every-developers#p56)

透過性や遅延評価、制御周りで必要性が出そうな感じ