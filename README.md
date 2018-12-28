# Data-Structure
自己手写的一些基础数据结构，动态数组、链表、队列、栈、二叉树、二分搜索树、集合等，另附部分Leetcode题目解决方案。
本项目使用idea工具编写，部分模块之间存在依赖关系。具体依赖关系如下。

1. 模块 05-Set 依赖 03-LinkedList 和 04-Tree
2. 模块 06-Map 依赖 04-Tree
3. 模块 07-MaxHeap 依赖 02-Stack

idea用户进行模块间依赖管理请执行如下操作：

1. 打开项目结构设置，依次点击`File-Project Structure`，或者使用快捷键`Ctrl + Shift + S`。
2. 选择`Modules`，点击`05-LinkedList`，再选择右侧`Dependencies`，点击右侧`+`按钮，选择`Module Dependency`。
3. 然后选择要依赖的模块，我们这里选择`03-LinkedList`和`04-Tree`即可，然后确定即可完成模块间依赖。

Tips：模块间依赖：在IDEA中，如果A模块依赖B模块，那就意味着A模块可以使用B模块中的代码。