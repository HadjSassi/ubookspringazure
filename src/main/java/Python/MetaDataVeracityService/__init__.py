import PyPDF2
from pptx import Presentation
from docx import Document

file = ""
metaData = {"Author": "", "Year": "", "Title": ""}


def pdfinf(chaine):
    pdf = PyPDF2.PdfFileReader(chaine)
    data = pdf.getDocumentInfo()
    metaData["Author"] = data["/Author"]
    metaData["Year"] = data["/CreationDate"][2:6]
    metaData["Title"] = data["/Title"]
    return data


def docxing(doc):
    df = Document(doc)
    data = getMetaData(df)
    metaData["Author"] = data["author"]
    metaData["Year"] = data["created"]
    metaData["Title"] = data["title"]
    return data


def pptxing(chaine):
    prs = Presentation(chaine)
    data = getMetaData(prs)
    metaData["Author"] = data["author"]
    metaData["Year"] = data["created"]
    metaData["Title"] = data["title"]
    return data


def getMetaData(doc):
    metadata = {}
    prop = doc.core_properties
    metadata["author"] = prop.author
    metadata["category"] = prop.category
    metadata["comments"] = prop.comments
    metadata["content_status"] = prop.content_status
    metadata["created"] = prop.created.year
    metadata["identifier"] = prop.identifier
    metadata["keywords"] = prop.keywords
    metadata["last_modified_by"] = prop.last_modified_by
    metadata["language"] = prop.language
    metadata["modified"] = prop.modified
    metadata["subject"] = prop.subject
    metadata["title"] = prop.title
    metadata["version"] = prop.version
    return metadata


def detectFile(file):
    data = 'Unkonw File'
    if file.endswith(".pdf"):
        data = pdfinf(file)
    elif file.endswith(".pptx"):
        data = pptxing(file)
    elif file.endswith(".docx"):
        data = docxing(file)
    else:
        print("File unknown type")
    return data


class MetaDataVeracityService:
    def __init__(self, file):
        detectFile(file)

    def getMetaData(self):
        return metaData
