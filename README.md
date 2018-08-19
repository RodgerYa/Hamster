# Hamster
account keeping 记账本

**首次拉取**

- `git clone git@github.com:yanwbo/Hamster.git` 执行命令，将远程仓库拉取到本地，进入目录 /Hamster

- 进入目录后，已经建立本地与远程仓库之间关联。可使用 `git checkout -b 分支名` 在本地新建自己的分支进行开发

- 合作开发者，提交时若远程仓库没有对应远程分支，可使用`git push --set-upstream origin 分支名` 在远端新建对应分支，提交使用 `git push origin/分支名` 即可

**app端说明**
- 初期采取前后端代码分离的方式管理，app代码存放在 [hamster-app][1] 仓库中，分开开发，分支分开管理。

[1]: https://github.com/yanwbo/Hamster-app
