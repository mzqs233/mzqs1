<div align="center">
<h1 align="center">
BILIBILI-HELPER
</h1>

</div>

## 工具简介

# 目录

- [目录](#目录)
    - [使用说明](#使用说明)
        - [一、Actions 方式](#一actions-方式)
        - [二、使用 Docker](#二使用-docker)
        - [三、使用 Linux Crontab 方式](#三使用-linux-crontab-方式)
        - [自定义功能配置](#自定义功能配置)
    - [订阅执行结果](#订阅执行结果)
        - [Server酱Turbo版](#server酱turbo版)
        - [Telegram订阅执行结果](#telegram订阅执行结果)
    - [更新和帮助](#更新和帮助)
        - [使用 Github Actions 自动同步源仓库代码](#使用-github-actions-自动同步源仓库代码)
        - [手动拉取最新代码](#手动拉取最新代码)
        - [使用Pull APP［推荐］](#使用pull-app推荐)
        - [常见问题解答](#常见问题解答)
    - [免责声明](#免责声明)
    - [API 参考列表](#api-参考列表)
    - [基于本项目的衍生项目](#基于本项目的衍生项目)
    - [致谢](#致谢)
    - [License](#license)
    - [Stargazers over time](#stargazers-over-time)

## 使用说明

### 一、Actions 方式

1. **Fork 本项目**
2. **获取 Bilibili Cookies**
3. 浏览器打开并登录 [bilibili 网站]()
4. 按 F12 打开 「开发者工具」 找到 应用程序/Application -\> 存储 -\> Cookies
5. 找到 `bili_jct` `SESSDATA` `DEDEUSERID` 三项，并复制值，创建对应的 GitHub Secrets。

![图示](docs/IMG/20201012001307.png)

1. **点击项目 Settings -\> Secrets -\> New Secrets 添加以下 3 个 Secrets，其中server酱微信推送的sckey可参阅[微信订阅通知](#微信订阅通知)**

| Name          | Value                                |
| ------------- | ------------------------------------ |
| DEDEUSERID    | 从 Cookie 中获取                     |
| SESSDATA      | 从 Cookie 中获取                     |
| BILI\_JCT     | 从 Cookie 中获取                     |
| SERVERPUSHKEY | server酱推送的sckey（兼容Turbo版本） |

![图示](docs/IMG/20201013210000.png)

1. **开启 Actions 并触发每日自动执行**

**Github Actions 默认处于关闭状态，还大家请手动开启 Actions ，执行一次工作流，验证是否可以正常工作。**

![图示](docs/IMG/workflow_dispatch.png)

**Fork 仓库后，GitHub 默认不自动执行 Actions 任务，请修改 `.github/trigger.json` 文件,将 `trigger` 的值改为 `1`，这样每天就会自动执行定时任务了。**

```patch
{
- "trigger": 0
+ "trigger": 1
}
```


}
```

如果需要修改每日任务执行的时间，请修改 `.github/workflows/auto_task_bilili.yml`，在第 12 行左右位置找到下如下配置。

```yml
  schedule:
    - cron: '30 10 * * *'
    # cron表达式，Actions时区是国际时间，国际时间10点的时候，国内时间是18点。
    # 示例： 每天晚上22点30执行 '30 14 * * *'
```
