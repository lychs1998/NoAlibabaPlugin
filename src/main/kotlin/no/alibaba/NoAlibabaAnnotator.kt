package no.alibaba

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiImportStatement
import com.intellij.psi.PsiTypeElement

class NoAlibabaAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element is PsiImportStatement) {
            if (element.getText().contains("com.alibaba")) {
                holder.newAnnotation(HighlightSeverity.ERROR, "禁止在代码中使用阿里轮子").range(element)
                    .create()
            }
        } else if (element is PsiTypeElement) {
            if (element.type.canonicalText.contains("com.alibaba")) {
                holder.newAnnotation(HighlightSeverity.ERROR, "禁止在代码中使用阿里轮子").range(element)
                    .create()
            }
        }
    }
}