package com.example.devyaniproject.mindorkjetpackcompose.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.devyaniproject.mindorkjetpackcompose.data.Blog

class DummyBlogProvider : PreviewParameterProvider<Blog> {
    override val values =
        sequenceOf(Blog("Learning Compose", "MindOrks"), Blog("Learning Android", "MindOrks"))
    override val count: Int = values.count()
}