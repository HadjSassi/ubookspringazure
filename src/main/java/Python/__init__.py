import sys

from MetaDataVeracityService import MetaDataVeracityService
from SubjectVeracityService import SubjectVeracityService

confirmation = "NotYet"

link = sys.argv[1]
nom = sys.argv[2]
matiere = sys.argv[3]
year = sys.argv[4]
creative = sys.argv[5]

metaData = MetaDataVeracityService(link)
subject = SubjectVeracityService(link)

# print(metaData.getMetaData())
# print(subject.getSubject())


def verifyAuthor():
    y = creative.find('property=cc:attributionName>')
    z = creative.find('</span>', y)
    y += len('property=cc:attributionName>')
    author = str(creative[y:z].lower().replace(' ', ''))
    author2 = str(metaData.getMetaData()['Author'].lower().replace(' ', ''))
    if(len(author)== 0):
        author = "&²-è_çà)=!!ù:;°°]}"
    if author2.__contains__(author) != 0 or author.__contains__(author2) != 0:
        msg = "Author Confirmed\n"
    else:
        msg = "Author is not verified!\n"
    return msg


def verifyYear():
    year1 = int(metaData.getMetaData()["Year"])
    if year1 - int(year) == 0:
        msg = "Year Confirmed\n"
    else:
        msg = "Year is not verified!\n"
    return msg


def verifySubject():
    subject1 = subject.getSubject()
    if (subject1 == matiere):
        msg = "Subject Confirmed\n"
    else:
        msg = "Subject is not verified!\n"
    return msg


def conclusion():
    msg = ""
    aut = verifyAuthor()
    yea = verifyYear()
    sub = verifySubject()
    msg += aut
    msg += yea
    msg += sub
    return msg


msg = conclusion()
print(msg)


